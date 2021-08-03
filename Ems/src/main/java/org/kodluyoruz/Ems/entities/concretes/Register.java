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
@Table(name = "register")
@NoArgsConstructor
@AllArgsConstructor
public class Register {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	@PrimaryKeyJoinColumn
	private int registerId;
	
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationalty_identity")
	private String nationaltyIdentity;

	@Column(name = "date_of_birth")
	private String dateofBirth;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

	
	
}
