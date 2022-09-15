package com.acme.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "ORDER_ITEMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_ITEMS_SEQ", allocationSize = 1)
public class OrderItem extends BaseModel {

	@Min(value = 0)
	@Column(precision = 10, scale = 2, nullable = false)
	@NotNull
	private Integer quantity;

	@Column(precision = 10, scale = 2, nullable = false)
	@Min(value = 0)
	@NotNull
	private BigDecimal price;

	@OneToOne
	@NotNull
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	@ToString.Exclude
	private Order order;

}
