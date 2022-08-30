package com.acme.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "ORDER_ITEM")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_ITEMS_SEQ", initialValue = 1, allocationSize = 1)
public class OrderItem extends BaseModel {
	@Min(value = 0)
	@Column(precision = 15, scale = 2, nullable = false)
	@NotNull
	private Integer quantity;
	@Column(precision = 15, scale = 2, nullable = false)
	@Min(value = 0)
	@NotNull
	private BigDecimal price;
	@OneToOne
	@NotNull
	private Product product;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JsonIgnore
	private Order order;

}
