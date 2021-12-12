package com.data.hr.controller;

import com.data.hr.dto.JobHistory;
import com.data.hr.service.ServiceJobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerJobHistory {

    @Autowired
    ServiceJobHistory serviceJobHistory;

    @PostMapping("/jobHistory/{id}")
    public List<JobHistory> getByIdJobHistory(@PathVariable("id") int employee_id){
        return serviceJobHistory.getById(employee_id);
    }

    @PostMapping("/jobHistory")
    public List<JobHistory> getAllJobHistory(){
        return serviceJobHistory.allJobHistory();
    }
}
