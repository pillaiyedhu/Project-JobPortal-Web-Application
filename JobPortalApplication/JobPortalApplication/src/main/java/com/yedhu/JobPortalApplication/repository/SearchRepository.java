package com.yedhu.JobPortalApplication.repository;

import com.yedhu.JobPortalApplication.entity.JobPost;
import org.springframework.stereotype.Component;

import java.util.List;



public interface SearchRepository {
    List<JobPost> findByText(String text);
}
