package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EmployeeBean;
import com.dao.EmployeeDao;

@Controller
//@RequestMapping("/employee")
public class EmployeeController {

	/*
	 * @RequestMapping("/dashbord") public String dashBoard() {
	 * 
	 * return "redirect:newdashbord"; }
	 * 
	 * @RequestMapping("/newdashbord") public String newDashboard() {
	 * 
	 * System.out.println("new dashbord called...");
	 * 
	 * return "home"; }
	 */

	@Autowired
	EmployeeDao employeeDao;

	@RequestMapping("/addemployee")
	public String addEmployee(Model model) {

		EmployeeBean employeeBean = new EmployeeBean();
		model.addAttribute("employeeBean", employeeBean);

		return "addEmployee";
	}

	/*
	 * // get,post,put,delete // @RequestMapping("/insertemployee")
	 * //@RequestMapping(value = "/insertemployee", method = RequestMethod.POST)
	 * 
	 * @PostMapping(value = "insertemployee") //@GetMapping public String
	 * insertEmployee(
	 * 
	 * @RequestParam("txtEmployeeName") String eName,
	 * 
	 * @RequestParam("txtEmployeeAge") String eAge ) {
	 * 
	 * System.out.println("insert employee");
	 * System.out.println("employeeName ="+eName);
	 * System.out.println("employeeAge = "+eAge); return "home"; }
	 */

	@PostMapping(value = "/insertemployee")
	public String insertEmployee(EmployeeBean employeeBean) {

		int res = employeeDao.addEmployee(employeeBean);
		if (res > 0) {

			return "home";
		}

		return "home";
	}

	@GetMapping(value = "/viewemployees")
	public String employeeList(Model model) {

		List<EmployeeBean> list = employeeDao.getAllEmployees();
		model.addAttribute("emplist", list);

		return "employeelist"; 
		
	}
	@RequestMapping(value = "/deleteemployee/{ename}")
	public String deleteEmployee(@PathVariable("ename") String eName) {
		
		System.out.println("ename ="+eName);
		return "home";
	}

}
