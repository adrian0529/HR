package com.data.hr.dao;

import com.data.hr.dto.JobHistory;

import java.util.List;

public interface DaoJobHistory {
    List<JobHistory> getById(int employee_id);
    List<JobHistory> allJobHistory();
}
