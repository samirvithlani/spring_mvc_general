package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.EmployeeBean;

@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<EmployeeBean> getAllEmployees() {

		return jdbcTemplate.query("select * from employee", new EmployeeMapper());
	}

	private final static class EmployeeMapper implements RowMapper<EmployeeBean> {

		@Override
		public EmployeeBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.seteAge(rs.getInt("eage"));
			employeeBean.setEmployeeName(rs.getString("eName"));

			return employeeBean;
		}

	}

	public int addEmployee(EmployeeBean employeeBean) {

		return jdbcTemplate.update("insert into employee(ename,eage)values(?,?)", employeeBean.getEmployeeName(),
				employeeBean.geteAge());
	}

}
