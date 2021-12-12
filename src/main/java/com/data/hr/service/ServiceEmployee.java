package com.data.hr.service;

import com.data.hr.dto.Employee;

import java.util.List;

public interface ServiceEmployee {
    Employee save(Employee employee);
    Employee update(Employee employee);
    Employee getById(int employee_id);
    String delete(int employee_id);
    List<Employee> allEmployees();
}
