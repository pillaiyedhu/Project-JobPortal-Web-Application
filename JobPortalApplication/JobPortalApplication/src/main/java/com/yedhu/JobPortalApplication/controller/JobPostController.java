package com.yedhu.JobPortalApplication.controller;


import com.yedhu.JobPortalApplication.entity.JobPost;
import com.yedhu.JobPortalApplication.repository.JobPostRepository;
import com.yedhu.JobPortalApplication.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    JobPostRepository repo;

    @Autowired
    SearchRepository srepo;


    @GetMapping("/show")
    public List<JobPost> showData(){
        return repo.findAll();
    }

    @PostMapping("/post")
    public JobPost postData(@RequestBody JobPost jobPost){

        return repo.save(jobPost);
    }


    @GetMapping("/search/{text}")
    public List<JobPost> search(@PathVariable String text){
        return srepo.findByText(text);
    }

}
