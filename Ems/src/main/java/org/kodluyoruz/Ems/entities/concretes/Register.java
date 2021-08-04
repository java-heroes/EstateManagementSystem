package org.kodluyoruz.Ems.entities.concretes;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "register")
@NoArgsConstructor
@AllArgsConstructor
public class Register {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "register_id")
	@PrimaryKeyJoinColumn
	private int registerid;
	
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastname;

	@Column(name = "nationalty_identity")
	private String nationaltyidentity;

	@Column(name= "date_of_birth",columnDefinition = "Date default CURRENT_DATE")
	private Date dateOfBirth;

	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
