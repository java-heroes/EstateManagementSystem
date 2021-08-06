package org.kodluyoruz.Ems.core.utilities.ImageService;

import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
	
	 DataResult<?> save(MultipartFile file);
	
}
