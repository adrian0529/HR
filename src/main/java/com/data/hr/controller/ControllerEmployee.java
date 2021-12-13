package com.data.hr.controller;

import com.data.hr.dto.Employee;
import com.data.hr.service.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
public class ControllerEmployee {
    @Autowired
    ServiceEmployee serviceEmployee;

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return serviceEmployee.save(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return serviceEmployee.update(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int employee_id){
        return serviceEmployee.getById(employee_id);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") int employee_id){
        return serviceEmployee.delete(employee_id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return serviceEmployee.allEmployees();
    }

}
