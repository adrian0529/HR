package com.data.hr.service;

import com.data.hr.dao.DaoDepartment;
import com.data.hr.dto.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ServiceDepartmentImp implements ServiceDepartment{
    private final Logger log = LoggerFactory.getLogger(ServiceDepartmentImp.class);

    @Autowired
    DaoDepartment daoDepartment;

    @Override
    public Department save(Department department) {
        return daoDepartment.save(department);
    }

    @Override
    public Department update(Department department) {
        return daoDepartment.update(department);
    }

    @Override
    public Department getById(int department_id) {
        return daoDepartment.getById(department_id);
    }

    @Override
    public String delete(int department_id) {
        return daoDepartment.delete(department_id);
    }

    @Override
    public List<Department> allDepartments() {
        return daoDepartment.allDepartments();
    }
}
