package org.kodluyoruz.Ems.business.concretes;

import java.util.List;
import java.util.Optional;

import org.kodluyoruz.Ems.business.abstracts.SellersService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
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
	
	@Override
	public Result delete(Seller seller ) {
		this.sellerDao.deleteById(seller.getSellersid());
		return new SuccessResult("Seller deleted successfully.");
	}

	@Override
	public Result update(Seller seller) {
		Optional<Seller> getSeller = sellerDao.findById(seller.getSellersid());
		  if(!getSeller.isPresent()) {
		         return new ErrorResult("User id not found");
		    	
		    }
	    this.sellerDao.save(seller);
	    
		return new SuccessResult("Seller information updated");
	}

	@Override
	public DataResult<Seller> getById(int id) {
	
		return new SuccessDataResult<Seller>(this.sellerDao.getById(id));
	}
		}
   
	

