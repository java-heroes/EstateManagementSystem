package org.kodluyoruz.Ems.entities.concretes;

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
@Table(name = "sellers")
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "sellers_id")
	@PrimaryKeyJoinColumn
	private int sellersid;
	
	@Column(name = "company_name")
	private String companyname;
	
	@Column(name ="phone_number")
	private String phonenumber;
	
	@Column(name ="web_address")
	private String webaddress;
	
	
	

}
