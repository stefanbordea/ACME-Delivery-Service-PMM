package com.acme.delivery.domain;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@SuperBuilder
@ToString(callSuper = true)
@Entity
@Table(name = "ORDER", indexes = {@Index(name = "ORDER_IDX_01", columnList = "serial")})
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_SEQ", initialValue = 1, allocationSize = 1)
public class Order extends BaseModel
{
  @ManyToOne
  @JoinColumn(name = "customer_id")
    private Account customer;
	@ManyToOne
	@JoinColumn(name = "deliveryAddress_id")
    private Address deliveryAddress;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
    private PaymentMethod paymentMethod;
	@Column(length = 50, nullable = false)
    private String serial;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
    private Date date;
	@Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;
	@OneToMany(mappedBy = "order",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;
}
