package org.kodluyoruz.Ems.business.concretes;

import java.util.List;
import java.util.Optional;

import org.kodluyoruz.Ems.business.abstracts.UserService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.UserDao;
import org.kodluyoruz.Ems.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users in the system are listed ✓");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email), "Email found");
	}

	@Override
	public DataResult<User> getById(int id) {
		return new SuccessDataResult<User>(this.userDao.getById(id));
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("The User has been added to the system ✓");
	}

	@Override
	public Result update(User user) {
		Optional<User> getUser = userDao.findById(user.getId());
		  if(!getUser.isPresent()) {
		         return new ErrorResult("User id not found");
		    	
		    }
	    this.userDao.save(user);
	    
		return new SuccessResult("User information updated");
	}

	@Override
	public Result delete(User user) {
		this.userDao.deleteById(user.getId());
		return new SuccessResult("User deleted successfully");
	}

}