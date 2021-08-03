package org.kodluyoruz.Ems.dataAccess.abstracts;

import org.kodluyoruz.Ems.entities.concretes.HomeInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeInformationDao extends JpaRepository<HomeInformation, Integer>  {


}