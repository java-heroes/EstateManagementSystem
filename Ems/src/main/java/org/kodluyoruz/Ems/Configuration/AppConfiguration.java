package org.kodluyoruz.Ems.Configuration;

import org.kodluyoruz.Ems.core.utilities.ImageService.ImageService;
import org.kodluyoruz.Ems.core.utilities.ImageService.Cloudinary.CloudinaryImageManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfiguration {
	
	@Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dnzvf9zyp",
                "api_key", "557719611285613",
                "api_secret", "kwOI2taPefd_GORZK2KFjVFkx3Q"));
    }

    @Bean
    public ImageService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
	
}
