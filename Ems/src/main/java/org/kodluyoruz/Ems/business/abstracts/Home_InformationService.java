package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.Home_Information;

public interface Home_InformationService {
	DataResult<List<Home_Information>>  get() ; 
    Result add(Home_Information homeInformation);
    Result delete(Home_Information homeInformation);
    Result update(Home_Information homeInformation);
	DataResult<Home_Information> getById(int id);
}
