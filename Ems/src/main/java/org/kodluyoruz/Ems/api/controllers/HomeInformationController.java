package org.kodluyoruz.Ems.api.controllers;

import java.util.List;


import org.kodluyoruz.Ems.business.abstracts.HomeInformationService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.HomeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/homeInformation")
@CrossOrigin
public class HomeInformationController {
	
	private HomeInformationService homeInformationService;
	
	
	
	@Autowired
	public HomeInformationController(HomeInformationService homeInformationService) {
		this.homeInformationService = homeInformationService;
	}
	@GetMapping("/getAll")
	public DataResult<List<HomeInformation>> getAll() {
		return this.homeInformationService.get();
	}

	@PostMapping("/add")
	public Result add(HomeInformation homeInformation , @RequestBody MultipartFile file) {
		return this.homeInformationService.add(homeInformation);
		

	}
	
	@GetMapping("/get/{id}")
	public DataResult<HomeInformation> getById(@PathVariable int id) {
		return this.homeInformationService.getById(id);
	}
	
	
	
	 
	   
	 @DeleteMapping("/delete")
	public Result delete(@RequestBody HomeInformation homeInformation) {
			return this.homeInformationService.delete(homeInformation);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  HomeInformation homeInformation) {
			return this.homeInformationService.update(homeInformation);
		}
	   
	
			
		
		
	   
}
