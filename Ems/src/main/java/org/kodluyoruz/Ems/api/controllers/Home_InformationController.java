package org.kodluyoruz.Ems.api.controllers;

import java.util.List;
import org.kodluyoruz.Ems.business.abstracts.Home_InformationService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Home_Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home_information")
public class Home_InformationController {
	private Home_InformationService homeInformationService;
	
	@Autowired
	public Home_InformationController(Home_InformationService homeInformationService) {
		this.homeInformationService = homeInformationService;
	}
	@GetMapping("/getAll")
	public DataResult<List<Home_Information>> getAll() {
		return this.homeInformationService.get();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Home_Information homeInformation) {
		return this.homeInformationService.add(homeInformation);

	}

	@GetMapping("/get/{id}")
	public DataResult<Home_Information> getById(@PathVariable int id) {
		return this.homeInformationService.getById(id);
	}
	
	 
	   
	 @DeleteMapping("/delete")
	public Result delete(@RequestBody Home_Information homeInformation) {
			return this.homeInformationService.delete(homeInformation);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Home_Information homeInformation) {
			return this.homeInformationService.update(homeInformation);
		}
}
