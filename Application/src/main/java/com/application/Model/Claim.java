package com.application.Model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer claimId;
	@Length(min=4,max=20)
	private String description;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date claimDate=new Date();
	@JsonProperty(access = Access.READ_ONLY)
	private boolean claimStatus;
	
	@OneToOne
	@JsonProperty(access = Access.READ_ONLY)
	private InsurancePolicy policy;
}
