package sasa.jovanovic.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sasa.jovanovic.thymeleafdemo.entity.Employee;
import sasa.jovanovic.thymeleafdemo.service.EmployeeService;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> employees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

		Employee employee = employeeService.findById(id);

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.save(employee);

		return "redirect:/employees/list";
	}
}









