package org.kodluyoruz.Ems.api.controllers;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.SeekersService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Seeker;
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
@RequestMapping("/api/seekers")
public class SeekersController {
	private SeekersService seekersService;

	@Autowired
	public SeekersController(SeekersService seekersService) {
		this.seekersService = seekersService;

	}
	

	@GetMapping("/getAll")
	public DataResult<List<Seeker>> getAll() {
		return this.seekersService.get();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Seeker seeker) {
		return this.seekersService.add(seeker);

	}

	@GetMapping("/get/{id}")
	public DataResult<Seeker> getById(@PathVariable int id) {
		return this.seekersService.getById(id);
	}
	
	 
	   
	 @DeleteMapping("/delete")
	public Result delete(@RequestBody Seeker seeker) {
			return this.seekersService.delete(seeker);
		}
	   
	   @PutMapping("/update")
		public Result update(@RequestBody  Seeker seeker) {
			return this.seekersService.update(seeker);
		}



}
