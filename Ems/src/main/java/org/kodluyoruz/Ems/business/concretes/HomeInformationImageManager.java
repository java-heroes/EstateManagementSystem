package org.kodluyoruz.Ems.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.kodluyoruz.Ems.business.abstracts.HomeInformationImageService;
import org.kodluyoruz.Ems.core.utilities.ImageService.ImageService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.HomeInformationImageDao;
import org.kodluyoruz.Ems.entities.concretes.HomeInformationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class HomeInformationImageManager implements HomeInformationImageService{
	
	
	private HomeInformationImageDao homeInformationImageDao;
	private ImageService imageService;
	
	@Autowired
	public HomeInformationImageManager(HomeInformationImageDao homeInformationImageDao,ImageService imageService) {
		super();
		this.homeInformationImageDao = homeInformationImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(HomeInformationImage homeInformationImage) {
		this.homeInformationImageDao.save(homeInformationImage);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<HomeInformationImage> homeInformationImages) {
		homeInformationImageDao.saveAll(homeInformationImages);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public Result add(HomeInformationImage homeInformationImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        homeInformationImage.setUrl(url);
        homeInformationImage.setUploadedDate(LocalDateTime.now());
        return add(homeInformationImage);
	}

	@Override
	public DataResult<List<HomeInformationImage>> getAll() {
		return new SuccessDataResult<>(this.homeInformationImageDao.findAll());
	}

	@Override
	public DataResult<List<HomeInformationImage>> getAllByHomeInformationId(int homeInformationId) {
		return new SuccessDataResult<>(this.homeInformationImageDao.getAllById(homeInformationId));
	}
	
}
