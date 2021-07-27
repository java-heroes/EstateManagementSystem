package org.kodluyoruz.Ems.dataAccess.abstracts;

import org.kodluyoruz.Ems.entities.concretes.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerDao extends JpaRepository<Seeker, Integer>{

}
