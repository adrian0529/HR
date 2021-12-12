package com.data.hr.service;

import com.data.hr.dto.Job;

import java.util.List;

public interface ServiceJob {
    Job save(Job job);
    Job update(Job job);
    Job getById(String job_id);
    String delete(String job_id);
    List<Job> allJobs();
}
