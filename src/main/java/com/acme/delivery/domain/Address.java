package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESSES")
@SequenceGenerator(name = "idGenerator", sequenceName = "ADDRESSES_SEQ", allocationSize = 1)
public class Address extends BaseModel{

	@Column(length = 50, nullable = false)
	@NotEmpty
    private String street;

	@Column(length = 10, nullable = false)
	@NotEmpty
    private String streetNumber;

	@Column(length = 10, nullable = false)
	@NotEmpty
    private String zipCode;

	@Column(length = 40, nullable = false)
	@NotEmpty
    private String region;
}
