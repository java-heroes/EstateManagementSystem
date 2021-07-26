package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;

import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.User;

public interface UserService {

	DataResult<List<User>> getAll();
	DataResult<User> getByEmail(String email);
	DataResult<User> getById(int id);
	Result add(User user);
	Result delete(User user);
	Result update(User user);
}