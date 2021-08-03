package org.kodluyoruz.Ems.business.concretes;

import java.util.List;

import org.kodluyoruz.Ems.business.abstracts.HomeInformationService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.HomeInformationDao;
import org.kodluyoruz.Ems.entities.concretes.HomeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeInformationManager implements HomeInformationService{

	private HomeInformationDao homeInformationDao;
	
	@Autowired
	public HomeInformationManager(HomeInformationDao homeInformationDao) {
		super();
		this.homeInformationDao = homeInformationDao;
	}
	
	@Override
	public DataResult<List<HomeInformation>> get() {
		return new SuccessDataResult<List<HomeInformation>>(this.homeInformationDao.findAll(),"List of all houses.");
	}

	@Override
	public Result add(HomeInformation homeInformationDao) {
		this.homeInformationDao.save(homeInformationDao);
		return new SuccessResult("The house has been successfully added.");
	}

	@Override
	public Result delete(HomeInformation homeInformation) {
		this.homeInformationDao.deleteById(homeInformation.getHomeInformationId());
		return new SuccessResult("The house has been successfully deleted.");
	}

	@Override
	public Result update(HomeInformation homeInformation) {
		java.util.Optional<HomeInformation> getHomeInformation = 
				this.homeInformationDao.findById(homeInformation.getHomeInformationId());
		if(!getHomeInformation.isPresent()) {
	         return new ErrorResult("There is no such house.");
	    	
	    }else{
	       this.homeInformationDao.save(homeInformation);
		   return new SuccessResult("The home has been successfully updated.");
	    }
	}

	@Override
	public DataResult<HomeInformation> getById(int id) {
		return new SuccessDataResult<HomeInformation>(this.homeInformationDao.getById(id));
	}

}
