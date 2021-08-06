package org.kodluyoruz.Ems.business.abstracts;

import java.util.List;

import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.entities.concretes.HomeInformationImage;
import org.springframework.web.multipart.MultipartFile;

public interface HomeInformationImageService {
	
	Result add(HomeInformationImage homeInformationImage);
	Result addAll(List<HomeInformationImage> homeInformationImages);
	Result add(HomeInformationImage homeInformationImage, MultipartFile file);

	DataResult<List<HomeInformationImage>> getAll();
	DataResult<List<HomeInformationImage>> getAllByHomeInformationId(int homeInformationId);
	
}
