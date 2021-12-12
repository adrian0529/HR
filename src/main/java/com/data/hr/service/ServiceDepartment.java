package com.data.hr.service;

import com.data.hr.dto.Department;

import java.util.List;

public interface ServiceDepartment {
    Department save(Department department);
    Department update(Department department);
    Department getById(int department_id);
    String delete(int department_id);
    List<Department> allDepartments();
}
