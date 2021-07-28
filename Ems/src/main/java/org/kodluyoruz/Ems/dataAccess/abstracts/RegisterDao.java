package org.kodluyoruz.Ems.dataAccess.abstracts;


import org.kodluyoruz.Ems.entities.concretes.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterDao extends JpaRepository<Register, Integer>  {


}
