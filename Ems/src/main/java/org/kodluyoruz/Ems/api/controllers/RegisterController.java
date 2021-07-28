package org.kodluyoruz.Ems.api.controllers;


import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.RegisterService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/register")
public class RegisterController {

	 private RegisterService registerService;
 
	   @Autowired
	   public RegisterController(RegisterService  registerService) {
		   this.registerService=registerService;
		   
	   }
	   

		@GetMapping("/getById")
		public DataResult<Register> getById(@RequestParam int id) {
			return this.registerService.getById(id);

		}
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Register>>  getAll() {
		   return  this.registerService.getAll();
	   }
	   
	   @PostMapping("/add")
	   public Result add(@RequestBody Register register) {
		   return this.registerService.add(register);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody  Register register) {
			return this.registerService.delete(register);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Register register) {
			return this.registerService.update(register);
		}
	  

}
