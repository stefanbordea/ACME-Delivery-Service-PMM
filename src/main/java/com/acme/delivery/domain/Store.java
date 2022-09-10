package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
	@Column(length = 20)
	private String openDays;
	@Enumerated(EnumType.STRING)
	private StoreCategory category;
	@OneToOne
	@Transient
	private Address address;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "store_products", joinColumns = {@JoinColumn(name = "store_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
	private Set<Product> productsMenu;
}
