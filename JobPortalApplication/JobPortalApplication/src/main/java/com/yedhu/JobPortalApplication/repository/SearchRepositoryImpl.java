package com.yedhu.JobPortalApplication.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.yedhu.JobPortalApplication.entity.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String text) {




        List<JobPost> list = new ArrayList<>();

        MongoDatabase database = client.getDatabase("yedhu");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", new Document("text", new Document("query", "java").append("path", Arrays.asList("desc", "techs", "profile")))), new Document("$sort", new Document("exp", 1L)), new Document("$limit", 5L)));

        result.forEach(document -> list.add(converter.read(JobPost.class,document)));

        return list;


    }
}
