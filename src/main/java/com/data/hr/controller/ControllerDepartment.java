package com.data.hr.controller;

import com.data.hr.service.ServiceDepartment;
import com.data.hr.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerDepartment {

    @Autowired
    ServiceDepartment serviceDepartment;

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department){
        return serviceDepartment.save(department);
    }

    @PutMapping("/department")
    public Department updateDepartment(@RequestBody Department department){
        return serviceDepartment.update(department);
    }

    @PostMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") int department_id){
        return serviceDepartment.getById(department_id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartment(@PathVariable("id") int department_id){
        return serviceDepartment.delete(department_id);
    }

    @PostMapping("/departments")
    public List<Department> getDepartments(){
        return serviceDepartment.allDepartments();
    }
}
