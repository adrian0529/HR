package com.data.hr.controller;

import com.data.hr.dto.JobHistory;
import com.data.hr.service.ServiceJobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class ControllerJobHistory {

    @Autowired
    ServiceJobHistory serviceJobHistory;

    @GetMapping("/jobHistory/{id}")
    public List<JobHistory> getByIdJobHistory(@PathVariable("id") int employee_id){
        return serviceJobHistory.getById(employee_id);
    }

    @GetMapping("/jobHistory")
    public List<JobHistory> getAllJobHistory(){
        return serviceJobHistory.allJobHistory();
    }
}
