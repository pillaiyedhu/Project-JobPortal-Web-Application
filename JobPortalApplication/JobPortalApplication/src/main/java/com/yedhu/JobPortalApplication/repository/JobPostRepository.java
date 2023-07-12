package com.yedhu.JobPortalApplication.repository;

import com.yedhu.JobPortalApplication.entity.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobPostRepository extends MongoRepository<JobPost,String> {
}
