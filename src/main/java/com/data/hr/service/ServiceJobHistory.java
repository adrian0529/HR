package com.data.hr.service;

import com.data.hr.dto.JobHistory;

import java.util.List;

public interface ServiceJobHistory {
    List<JobHistory> getById(int employee_id);
    List<JobHistory> allJobHistory();
}
