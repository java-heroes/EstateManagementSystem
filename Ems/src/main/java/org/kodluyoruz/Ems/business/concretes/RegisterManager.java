package org.kodluyoruz.Ems.business.concretes;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.RegisterService;
import org.kodluyoruz.Ems.core.utilities.adapters.mernisServiceAdapter.FakeMernisAdapter;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.RegisterDao;
import org.kodluyoruz.Ems.entities.concretes.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterManager implements RegisterService {

	private RegisterDao registerDao;

	@Autowired
	public RegisterManager(RegisterDao registerDao) {
		super();
		this.registerDao = registerDao;
	}

	@Override
	public DataResult<List<Register>> getAll() {
		return new SuccessDataResult<List<Register>>(this.registerDao.findAll(), "Register list successfully.");
	}

	@Override
	public Result add(Register register) {
		FakeMernisAdapter checkIfRealPerson = new FakeMernisAdapter();
		boolean result = checkIfRealPerson.Control(register);
		if (result) {
			this.registerDao.save(register);
			return new SuccessResult("Register add successfully.");
		} else {
			return new ErrorResult("NOT real Person!");
		}
	}

	@Override
	public Result delete(Register register) {
		this.registerDao.deleteById(register.getRegisterId());
		return new SuccessResult("Register deleted successfully.");
	}

	@Override
	public Result update(Register register) {
		Optional<Register> getRegister = registerDao.findById(register.getRegisterId());

		if (!getRegister.isPresent()) {
			return new ErrorResult("there is no such id");

		}
		this.registerDao.save(register);
		return new SuccessResult("Register update successfully.");
	}

	@Override
	public DataResult<Register> getById(int id) {
		return new SuccessDataResult<Register>(this.registerDao.getById(id));
	}

}
