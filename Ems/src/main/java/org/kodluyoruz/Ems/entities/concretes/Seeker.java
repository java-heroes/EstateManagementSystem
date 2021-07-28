package org.kodluyoruz.Ems.entities.concretes;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seeker")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Seeker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seekers_id")
	@PrimaryKeyJoinColumn
	private int seekersId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

}
