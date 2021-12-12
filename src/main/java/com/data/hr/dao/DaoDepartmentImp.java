package com.data.hr.dao;

import com.data.hr.dto.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoDepartmentImp implements DaoDepartment{
    public static final String INSERT = "INSERT INTO departments (department_id, department_name, manager_id, location_id) VALUES (?,?,?,?)";
    public static final String UPDATE = "UPDATE departments SET department_name=?, manager_id=?, location_id=? WHERE department_id=?";
    public static final String GET_BY_ID = "SELECT * FROM departments WHERE department_id=?";
    public static final String DELETE = "DELETE FROM departments WHERE department_id=?";
    public static final String GET_ALL = "SELECT * FROM departments";

    JdbcTemplate jdbcTemplate;

    public DaoDepartmentImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Department save(Department department) {
        jdbcTemplate.update(INSERT,
                department.getDepartment_id(), department.getDepartment_name(), department.getManager_id(), department.getLocation_id());

        return department;
    }

    @Override
    public Department update(Department department) {
        jdbcTemplate.update(UPDATE,
                department.getDepartment_name(), department.getManager_id(), department.getLocation_id(), department.getDepartment_id());

        return department;
    }

    @Override
    public Department getById(int department_id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, (rs, rowNum) -> {
            return new Department(rs.getInt("department_id"), rs.getString("department_name"),
                    rs.getInt("manager_id"), rs.getInt("location_id"));
        }, department_id);
    }

    @Override
    public String delete(int department_id) {
        jdbcTemplate.update(DELETE, department_id);
        return "Department with ID " + department_id + " deleted";
    }

    @Override
    public List<Department> allDepartments() {
        return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
            return new Department(rs.getInt("department_id"), rs.getString("department_name"),
                    rs.getInt("manager_id"), rs.getInt("location_id"));
        });
    }
}
