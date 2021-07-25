package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String insertEmployee(@Valid @ModelAttribute("employeeBean") EmployeeBean employeeBean, BindingResult br) {

		if (br.hasErrors()) {

			return "addEmployee";
		}

		int res = employeeDao.addEmployee(employeeBean);
		if (res > 0) {

			return "redirect:viewemployees";
		}

		return "redirect:viewemployees";
	}

	@GetMapping(value = "/employeeLogin")
	public String employeeLogin(@RequestParam("txtEmployeeEmail") String eemail,
			@RequestParam("txtEmployeePassword") String epassword, HttpSession session) {

		EmployeeBean employeeBean = employeeDao.loginEmployee(eemail, epassword);
		if (employeeBean != null) {
			session.setAttribute("employeeBean", employeeBean);
			return "redirect:/viewemployees";
		}

		return "login";
	}

	@GetMapping(value = "/login")

	public String login() {

		return "login";
	}

	@GetMapping(value = "/viewemployees")
	public String employeeList(Model model) {

		List<EmployeeBean> list = employeeDao.getAllEmployees();
		model.addAttribute("emplist", list);

		return "employeelist";

	}

	@RequestMapping(value = "/deleteemployee/{eid}")
	public String deleteEmployee(@PathVariable("eid") int eId) {

		System.out.println("this method called..." + eId);
		employeeDao.deleteEmployee(eId);
		return "redirect:/viewemployees";
	}

	@RequestMapping(value = "/editemployee/{eid}")
	public String editEmployee(@PathVariable("eid") int eid, Model model) {

		EmployeeBean employeeBean = employeeDao.getEmployeeById(eid);
		model.addAttribute("employeeBean", employeeBean);
		return "editEmployee";
	}

	@RequestMapping(value = "/updateemployee")
	public String updateEmployee(EmployeeBean employeeBean) {

		employeeDao.updateEmployee(employeeBean);
		return "redirect:/viewemployees";
	}

}
