package org.kodluyoruz.Ems.api.controllers;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.UserService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();

	}

	@GetMapping("/getByEmail")
	public DataResult<User> getByEmail(@RequestParam String email) {
		return this.userService.getByEmail(email);

	}

	@GetMapping("/getById")
	public DataResult<User> getById(@RequestParam int id) {
		return this.userService.getById(id);

	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody User user) {
		return this.userService.delete(user);

	}

	@PostMapping("/add")
	public Result add(@RequestBody User user) {
		return this.userService.add(user);

	}

	@PostMapping("/update")
	public Result update(@RequestBody User user) {
	return this.userService.update(user);
	}

}