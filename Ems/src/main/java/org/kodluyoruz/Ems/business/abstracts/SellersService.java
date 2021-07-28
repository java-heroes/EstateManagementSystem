package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;

import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Seller;



public interface SellersService {
	DataResult<List<Seller>>  getAll() ; 
	DataResult<Seller> getById(int id);
    Result add(Seller seller);
    Result delete (Seller seller);
    Result update(Seller seller);
	 
}
