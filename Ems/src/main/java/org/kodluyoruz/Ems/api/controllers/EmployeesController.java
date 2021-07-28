package org.kodluyoruz.Ems.api.controllers;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.EmployeesService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Employee;
import org.kodluyoruz.Ems.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	 private EmployeesService employeesService;
 
	   @Autowired
	   public EmployeesController(EmployeesService employeesService) {
		   this.employeesService=employeesService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Employee>>  getAll() {
		   return  this.employeesService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Employee employee) {
		   return this.employeesService.add(employee);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Employee employee) {
			return this.employeesService.delete(employee);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Employee employee) {
			return this.employeesService.update(employee);
		}
	  
}
