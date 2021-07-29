package org.kodluyoruz.Ems.dataAccess.abstracts;

import org.kodluyoruz.Ems.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User getByEmail(String email);
	
}