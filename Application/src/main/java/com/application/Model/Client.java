package com.application.Model;


import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer clientId;
	@Length(min=5,max=10)
	private String name;
	@Past
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dob;
	@Length(min=5,max=10)
	private String address;
	@Length(min=10,max=10)
	private String phone;
	
//	@OneToMany
//	@JsonProperty(access = Access.READ_ONLY)
//	private List<InsurancePolicy> policies;
//	
//	@OneToMany
//	@JsonProperty(access = Access.READ_ONLY)
//	private List<Claim> claims;
}
