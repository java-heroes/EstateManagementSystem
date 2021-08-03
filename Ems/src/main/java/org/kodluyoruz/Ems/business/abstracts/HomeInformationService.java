package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.HomeInformation;

public interface HomeInformationService {
	DataResult<List<HomeInformation>>  get() ; 
    Result add(HomeInformation homeInformation);
    Result delete(HomeInformation homeInformation);
    Result update(HomeInformation homeInformation);
	DataResult<HomeInformation> getById(int id);
}
