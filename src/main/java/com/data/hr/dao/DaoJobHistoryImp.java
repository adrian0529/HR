package com.data.hr.dao;

import com.data.hr.dto.JobHistory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DaoJobHistoryImp implements DaoJobHistory {
    public static final String GET_BY_ID = "SELECT * FROM job_history WHERE employee_id=?";
    public static final String GET_ALL = "SELECT * FROM job_history";

    JdbcTemplate jdbcTemplate;

    public DaoJobHistoryImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<JobHistory> getById(int employee_id) {
        return jdbcTemplate.query(GET_BY_ID, (rs, rowNum) -> {
            return new JobHistory(rs.getInt("employee_id"), rs.getDate("start_date"),
                    rs.getDate("end_date"), rs.getString("job_id"), rs.getInt("department_id"));
        }, employee_id);
    }

    @Override
    public List<JobHistory> allJobHistory() {
        return jdbcTemplate.query(GET_ALL, (rs, rowNum) -> {
            return new JobHistory(rs.getInt("employee_id"), rs.getDate("start_date"),
                    rs.getDate("end_date"), rs.getString("job_id"), rs.getInt("department_id"));
        });
    }
}
