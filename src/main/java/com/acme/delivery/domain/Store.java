package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.DayOfWeek;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STORES")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORES_SEQ", allocationSize = 1)
public class Store extends BaseModel {

	@Column(length = 50, nullable = false, unique = true)
	private String name;
	@Column(length = 15, nullable = false)
	private String phoneNumber;
	@Column(length = 50, nullable = false)
	private String email;
	@Enumerated(EnumType.STRING)
	private Set<DayOfWeek> openDays;
	@Enumerated(EnumType.STRING)
	private Set<StoreCategory> categories;
	@Column(length = 50, nullable = false, unique = true)
	private Address address;
	@ManyToMany
	@JoinTable(name = "store_product", joinColumns = {@JoinColumn(name = "store_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
	private Set<Product> productsMenu;
}
