package com.data.hr.service;

import com.data.hr.dao.DaoJob;
import com.data.hr.dto.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceJobImp implements ServiceJob{
    private final Logger log = LoggerFactory.getLogger(ServiceJobImp.class);

    @Autowired
    DaoJob daoJob;

    @Override
    public Job save(Job job) {
        return daoJob.save(job);
    }

    @Override
    public Job update(Job job) {
        return daoJob.update(job);
    }

    @Override
    public Job getById(String job_id) {
        return daoJob.getById(job_id);
    }

    @Override
    public String delete(String job_id) {
        return daoJob.delete(job_id);
    }

    @Override
    public List<Job> allJobs() {
        return daoJob.allJobs();
    }
}
