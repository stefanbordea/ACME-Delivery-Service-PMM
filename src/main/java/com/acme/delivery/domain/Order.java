package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "ORDERS", indexes = {@Index(name = "ORDERS_IDX_01", columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDERS_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel
{
	@NotNull
	private Account account;
  
	@NotNull
	private Address deliveryAddress;
  
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	@NotNull
	private PaymentMethod paymentMethod;
  
	@Column(length = 50, nullable = false)
	private String serial;
  
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	@NotNull
	private Date order_date;
  
	@Column(precision = 15, scale = 2, nullable = false)
	@Min(value=0)
	@NotNull
	private BigDecimal totalPrice;
  
	@OneToMany(mappedBy = "order",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@NotNull
	private Set<OrderItem> orderItems;
}
