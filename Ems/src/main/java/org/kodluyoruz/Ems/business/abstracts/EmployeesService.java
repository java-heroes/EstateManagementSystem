package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;

import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Employee;



public interface EmployeesService {
	DataResult<List<Employee>>  getAll() ; 
    Result add(Employee employee);
    Result delete(Employee employee);
    Result update(Employee employee);
	DataResult<Employee> getById(int id);
    
}
