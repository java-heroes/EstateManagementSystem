package org.kodluyoruz.Ems.api.controllers;

import org.kodluyoruz.Ems.business.abstracts.HomeInformationImageService;
import org.kodluyoruz.Ems.entities.concretes.HomeInformation;
import org.kodluyoruz.Ems.entities.concretes.HomeInformationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/homeInformationImages")
public class HomeInformationImageController {
	
	
	private HomeInformationImageService homeInformationImageService;

	@Autowired
	public HomeInformationImageController(HomeInformationImageService homeInformationImageService) {
		super();
		this.homeInformationImageService = homeInformationImageService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int homeInformationID) {
		HomeInformationImage homeInformationImage = new HomeInformationImage();
		HomeInformation homeInformation = new HomeInformation();
		homeInformation.setHomeInformationId(homeInformationID);
		homeInformationImage.setHomeinformation(homeInformation);
		return ResponseEntity.ok(this.homeInformationImageService.add(homeInformationImage, file));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.homeInformationImageService.getAll());
	}
	
	@GetMapping("/getOne")
	public ResponseEntity<?> getOne(int homeInformationId) {
		return ResponseEntity.ok(this.homeInformationImageService.getAllByHomeInformationId(homeInformationId));
	}
	
	
}
