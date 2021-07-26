package org.kodluyoruz.Ems.business.concretes;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.EmployeesService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.EmployeeDao;
import org.kodluyoruz.Ems.entities.concretes.Employee;
import org.kodluyoruz.Ems.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class EmployeesManager implements EmployeesService{

private EmployeeDao employeesDao;

	
	@Autowired
	 public EmployeesManager(EmployeeDao employeesDao) {
		super();
		this.employeesDao=employeesDao;
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeesDao.findAll(),"Employees list successfully.");
	}

	@Override
	public Result add(Employee employee) {
		this.employeesDao.save(employee);
		return new SuccessResult("Employees add successfully.");
	}

	@Override
	public Result delete(Employee employee) {
	    this.employeesDao.deleteById(employee.getEmployeesid());
		return new SuccessResult("Employees deleted successfully.");
	}

	@Override
	public Result update(Employee employee) {
		  Optional<Employee> getEmployee = employeesDao.findById(employee.getEmployeesid());
		   
		    if(!getEmployee.isPresent()) {
		         return new ErrorResult("there is no such id");
		    	
		    }
		       this.employeesDao.save(employee);
			   return new SuccessResult("Employees update successfully."); 
	}		   
}
