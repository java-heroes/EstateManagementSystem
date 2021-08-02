package org.kodluyoruz.Ems.entities.concretes;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "home_information")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties (value = { "hibernateLazyInitializer", "handler"})
public class Home_Information {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	@PrimaryKeyJoinColumn
	private int homeInformationId;
	
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "balcony")
	private boolean balcony;
	
	@Column(name = "number_of_rooms")
	private int numberOfRooms;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private File image;
}
