package org.kodluyoruz.Ems.dataAccess.abstracts;

import java.util.List;

import org.kodluyoruz.Ems.entities.concretes.HomeInformationImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeInformationImageDao extends JpaRepository<HomeInformationImage, Integer>{
	
	List<HomeInformationImage> getAllById(int homeInformationId);
	List<HomeInformationImage> getById(int homeInformationId);
	
}
