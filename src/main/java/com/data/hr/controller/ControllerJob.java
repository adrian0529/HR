package com.data.hr.controller;

import com.data.hr.dto.Job;
import com.data.hr.service.ServiceJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerJob {

    @Autowired
    ServiceJob serviceJob;

    @PostMapping("/job")
    public Job addJob(@RequestBody Job job){
        return serviceJob.save(job);
    }

    @PutMapping("/job")
    public Job updateJob(@RequestBody Job job){
        return serviceJob.update(job);
    }

    @PostMapping("/job/{id}")
    public Job getJob(@PathVariable("id") String job_id){
        return serviceJob.getById(job_id);
    }

    @DeleteMapping("/job/{id}")
    public String deleteJob(@PathVariable("id") String job_id){
        return serviceJob.delete(job_id);
    }

    @PostMapping("jobs")
    public List<Job> getJobs(){
        return serviceJob.allJobs();
    }
}
