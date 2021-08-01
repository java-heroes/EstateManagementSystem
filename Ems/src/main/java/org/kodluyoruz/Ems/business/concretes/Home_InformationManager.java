package org.kodluyoruz.Ems.business.concretes;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.Home_InformationService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.Home_InformationDao;
import org.kodluyoruz.Ems.entities.concretes.Home_Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Home_InformationManager implements Home_InformationService{

	private Home_InformationDao homeInformationDao;
	
	@Autowired
	public Home_InformationManager(Home_InformationDao homeInformationDao) {
		super();
		this.homeInformationDao = homeInformationDao;
	}
	
	@Override
	public DataResult<List<Home_Information>> get() {
		return new SuccessDataResult<List<Home_Information>>(this.homeInformationDao.findAll(),"List of all houses.");
	}

	@Override
	public Result add(Home_Information homeInformationDao) {
		this.homeInformationDao.save(homeInformationDao);
		return new SuccessResult("The house has been successfully added.");
	}

	@Override
	public Result delete(Home_Information homeInformation) {
		this.homeInformationDao.deleteById(homeInformation.getHomeInformationId());
		return new SuccessResult("The house has been successfully deleted.");
	}

	@Override
	public Result update(Home_Information homeInformation) {
		java.util.Optional<Home_Information> getHomeInformation = 
				this.homeInformationDao.findById(homeInformation.getHomeInformationId());
		if(!getHomeInformation.isPresent()) {
	         return new ErrorResult("There is no such house.");
	    	
	    }else{
	       this.homeInformationDao.save(homeInformation);
		   return new SuccessResult("The home has been successfully updated.");
	    }
	}

	@Override
	public DataResult<Home_Information> getById(int id) {
		return new SuccessDataResult<Home_Information>(this.homeInformationDao.getById(id));
	}

}
