package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
public class Address extends BaseModel{

	@Column(length = 50, nullable = false)
    private String street;
	@Column(length = 10, nullable = false)
    private String streetNumber;
	@Column(length = 10, nullable = false)
    private String zipCode;
	@Column(length = 40, nullable = false)
    private String region;
}
