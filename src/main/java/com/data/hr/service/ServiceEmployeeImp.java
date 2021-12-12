package com.data.hr.service;

import com.data.hr.dao.DaoEmployee;
import com.data.hr.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceEmployeeImp implements ServiceEmployee{
    private final Logger log = LoggerFactory.getLogger(ServiceEmployeeImp.class);

    @Autowired
    private DaoEmployee daoEmployee;

    @Override
    public Employee save(Employee employee) {
        return daoEmployee.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return daoEmployee.update(employee);
    }

    @Override
    public Employee getById(int employee_id) {
        return daoEmployee.getById(employee_id);
    }

    @Override
    public String delete(int employee_id) {
        return daoEmployee.delete(employee_id);
    }

    @Override
    public List<Employee> allEmployees() {
        return daoEmployee.allEmployees();
    }
}
