package com.data.hr.dao;

import com.data.hr.dto.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoEmployeeImp implements DaoEmployee{
    public static final String INSERT = "INSERT INTO employees (employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    public static final String UPDATE = "UPDATE employees SET first_name=?, last_name=?, email=?, phone_number=?, hire_date=?, job_id=?, salary=?, commission_pct=?, manager_id=?, department_id=? WHERE employee_id=?";
    public static final String GET_BY_ID = "SELECT * FROM employees WHERE employee_id=?";
    public static final String DELETE = "DELETE FROM employees WHERE employee_id=?";
    public static final String GET_ALL = "SELECT * FROM employees";

    JdbcTemplate jdbcTemplate;

    public DaoEmployeeImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee save(Employee employee) {
        jdbcTemplate.update(INSERT,
                employee.getEmployee_id(), employee.getFirst_name(), employee.getLast_name(), employee.getEmail(),
                employee.getPhone_number(), employee.getHire_date(), employee.getJob_id(), employee.getSalary(),
                employee.getCommission_pct(), employee.getManager_id(), employee.getDepartment_id());

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        jdbcTemplate.update(UPDATE,
                employee.getFirst_name(), employee.getLast_name(), employee.getEmail(), employee.getPhone_number(),
                employee.getHire_date(), employee.getJob_id(), employee.getSalary(), employee.getCommission_pct(),
                employee.getManager_id(), employee.getDepartment_id(), employee.getEmployee_id());

        return employee;
    }

    @Override
    public Employee getById(int employee_id) {
        return jdbcTemplate.queryForObject(GET_BY_ID,(rs, rowNum) -> {
            return new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"),
                    rs.getString("phone_number"), rs.getDate("hire_date"),
                    rs.getString("job_id"), rs.getDouble("salary"),
                    rs.getDouble("commission_pct"), rs.getInt("manager_id"),
                    rs.getInt("department_id"));
        }, employee_id);
    }

    @Override
    public String delete(int employee_id) {
        jdbcTemplate.update(DELETE, employee_id);
        return "Employee with ID " + employee_id + " deleted";
    }

    @Override
    public List<Employee> allEmployees() {
        return jdbcTemplate.query(GET_ALL,(rs, rowNum) -> {
            return new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
                    rs.getString("last_name"), rs.getString("email"),
                    rs.getString("phone_number"), rs.getDate("hire_date"),
                    rs.getString("job_id"), rs.getDouble("salary"),
                    rs.getDouble("commission_pct"), rs.getInt("manager_id"),
                    rs.getInt("department_id"));
        });
    }
}
