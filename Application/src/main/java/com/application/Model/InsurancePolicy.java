package com.application.Model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Data
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer policyId;
	private PolicyType type;
	@Min(value=10000)
	private double coverageAmount;
	@Min(value=100)
	private double premium;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date startDate=new Date();
	@Future
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date endDate;
	
	@OneToOne
	@JsonProperty(access = Access.READ_ONLY)
	private Client policyHolder;
}
