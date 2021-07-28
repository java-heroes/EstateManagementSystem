package org.kodluyoruz.Ems.business.concretes;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.SellersService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.SellerDao;
import org.kodluyoruz.Ems.entities.concretes.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SellersManager implements SellersService{
	
	private SellerDao sellerDao;
	
	@Autowired
	 public SellersManager(SellerDao sellerDao) {
		super();
		this.sellerDao=sellerDao;
	}
	
	@Override
	public DataResult<List<Seller>>  getAll() {
	
		return new SuccessDataResult<List<Seller>>
		(this.sellerDao.findAll(),"house sellers listed");
		
	}

	@Override
	public Result add(Seller seller) {
		this.sellerDao.save(seller);
		return new SuccessResult("selling house added");
	}

}
