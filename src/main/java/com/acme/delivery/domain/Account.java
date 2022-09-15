package com.acme.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS", indexes = {@Index(name = "ACCOUNTS_IDX_01", columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", allocationSize = 1)
public class Account extends BaseModel {

	@Column(length = 50, nullable = false, unique = true)
	@NotEmpty
	@NotNull
	@Email
	private String email;

	@Column(length = 30, nullable = false)
	@NotNull
	@NotEmpty
	private String password;

	@Column(length = 30, nullable = false, unique = true)
	@NotEmpty
	@NotNull
	private String phoneNumber;

//	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Address> addresses;
}
