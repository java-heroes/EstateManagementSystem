package org.kodluyoruz.Ems.dataAccess.abstracts;

import org.kodluyoruz.Ems.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User getByEmail(String email);
	
}
