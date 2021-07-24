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
			employeeBean.seteEmail(rs.getString("eemail"));
			employeeBean.setePassword(rs.getString("epassword"));
			employeeBean.seteId(rs.getInt("eId"));

			return employeeBean;
		}

	}

	public int deleteEmployee(int eId) {

		return jdbcTemplate.update("delete from employee where eid = ?", eId);
	}

	public int updateEmployee(EmployeeBean employeeBean) {
		
		System.out.println("eid ="+employeeBean.geteId());
		return jdbcTemplate.update("update employee set eName =?,eemail=?,eage=?,epassword=? where eid =?",employeeBean.getEmployeeName(),employeeBean.geteEmail(),employeeBean.geteAge(),employeeBean.getePassword(),employeeBean.geteId());
	}

	public EmployeeBean getEmployeeById(int id) {

		return jdbcTemplate.queryForObject("select * from employee where eid =" + id + "", new EmployeeMapper());
	}

	public int addEmployee(EmployeeBean employeeBean) {

		return jdbcTemplate.update("insert into employee(ename,eemail,eage,epassword)values(?,?,?,?)",
				employeeBean.getEmployeeName(), employeeBean.geteEmail(), employeeBean.geteAge(),
				employeeBean.getePassword());
	}

}
