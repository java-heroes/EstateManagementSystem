package org.kodluyoruz.Ems.dataAccess.abstracts;

import org.kodluyoruz.Ems.entities.concretes.Home_Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Home_InformationDao extends JpaRepository<Home_Information, Integer>  {


}