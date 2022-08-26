package com.acme.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "ORDER_ITEM")
@SequenceGenerator(name = "idGenerator", sequenceName = "ORDER_ITEM_SEQ", initialValue = 1, allocationSize = 1)
public class OrderItem extends BaseModel {

    private Integer quantity;
	@Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal price;
	@ManyToOne
	@JoinColumn(name = "deliveryAddress_id")
    private Product product;
	@ManyToOne
	@JoinColumn(name = "order_id")
    private Order order;

}
