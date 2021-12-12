package com.data.hr.dao;

import com.data.hr.dto.Job;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoJobImp implements DaoJob{
    public static final String INSERT = "INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES (?,?,?,?)";
    public static final String UPDATE = "UPDATE jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
    public static final String GET_BY_ID = "SELECT * FROM jobs WHERE job_id=?";
    public static final String DELETE = "DELETE FROM jobs WHERE job_id=?";
    public static final String GET_ALL = "SELECT * FROM jobs";

    JdbcTemplate jdbcTemplate;

    public DaoJobImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Job save(Job job) {
        jdbcTemplate.update(INSERT,
                job.getJob_id(), job.getJob_title(), job.getMin_salary(), job.getMax_salary());

        return job;
    }

    @Override
    public Job update(Job job) {
        jdbcTemplate.update(UPDATE,
                job.getJob_title(), job.getMin_salary(), job.getMax_salary(), job.getJob_id());
        return job;
    }

    @Override
    public Job getById(String job_id) {
        return jdbcTemplate.queryForObject(GET_BY_ID, (rs, rowNum) -> {
            return new Job(rs.getString("job_id"), rs.getString("job_title"),
                    rs.getInt("min_salary"), rs.getInt("max_salary"));
        }, job_id);
    }

    @Override
    public String delete(String job_id) {
        jdbcTemplate.update(DELETE, job_id);

        return "Job with ID " + job_id + " deleted";
    }

    @Override
    public List<Job> allJobs() {
        return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
            return new Job(rs.getString("job_id"), rs.getString("job_title"),
                    rs.getInt("min_salary"), rs.getInt("max_salary"));
        });
    }
}
