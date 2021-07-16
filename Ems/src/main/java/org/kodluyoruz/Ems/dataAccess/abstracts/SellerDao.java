package org.kodluyoruz.Ems.dataAccess.abstracts;

import org.kodluyoruz.Ems.entities.concretes.Seller;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SellerDao extends JpaRepository<Seller, Integer>{

}
