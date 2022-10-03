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
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS", indexes = {@Index(name = "PRODUCT_IDX_01", columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "PRODUCTS_SEQ", allocationSize = 1)
public class Product extends BaseModel {

	@Column(length = 30, nullable = false, unique = true)
	@NotNull
	@NotEmpty
	private String serial;
	@Column(length = 50, nullable = false)
	@NotEmpty
	private String name;
	@Column(length = 150)
	@NotEmpty
	private String description;
	@Column(precision = 10, scale = 2, nullable = false)
	@NotNull
	private BigDecimal price;
	@Enumerated(EnumType.STRING)
	private ProductCategory categories;
}
