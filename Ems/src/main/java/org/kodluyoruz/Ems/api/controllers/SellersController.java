package org.kodluyoruz.Ems.api.controllers;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.SellersService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/sellers")
public class SellersController {

	   private SellersService sellersService;
	   
	   @Autowired
	   public SellersController(SellersService sellersService) {
		   this.sellersService=sellersService;
		   
	   }
	   
	   @GetMapping("/getAll")
	   public DataResult<List<Seller>>  getAll() {
		   return  this.sellersService.getAll();
	   }
		@GetMapping("/getById")
		public DataResult<Seller> getById(@RequestParam int id) {
			return this.sellersService.getById(id);
		}
	   @PostMapping("/add")
	   public Result add(@RequestBody Seller seller) {
		   return this.sellersService.add(seller);
		   
	   }
	   
	   @DeleteMapping("/delete")
		public Result delete(@RequestBody Seller seller) {
			return this.sellersService.delete(seller);

		}
		@PostMapping("/update")
		public Result update(@RequestBody Seller seller) {
		return this.sellersService.update(seller);
	   
        }
		
		
		
}
