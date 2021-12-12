package com.data.hr.service;

import com.data.hr.dao.DaoJobHistory;
import com.data.hr.dto.JobHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceJobHistoryImp implements ServiceJobHistory{
    private final Logger log = LoggerFactory.getLogger(ServiceJobImp.class);

    @Autowired
    DaoJobHistory daoJobHistory;

    @Override
    public List<JobHistory> getById(int employee_id) {
        return daoJobHistory.getById(employee_id);
    }

    @Override
    public List<JobHistory> allJobHistory() {
        return daoJobHistory.allJobHistory();
    }
}
