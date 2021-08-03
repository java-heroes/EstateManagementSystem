package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;

import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Register;




public interface RegisterService {
	DataResult<List<Register>>  getAll() ; 
	DataResult<Register> getById(int id);
    Result add(Register register);
    Result delete(Register register);
    Result update(Register register);


    
}






