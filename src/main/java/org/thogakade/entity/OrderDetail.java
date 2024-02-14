package org.thogakade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(OrderDetail_PK.class)
public class OrderDetail {

    @Id
    private String itemCode;
    @Id
    private String orderID;
    private int qty;
    private double unitPrice;
    private int discount;
    @ManyToOne
    @JoinColumn(name = "orderID",insertable = false,updatable = false)
    Orders orders;
    @ManyToOne
    @JoinColumn(name = "itemCode",insertable = false,updatable = false)
    Item item;
}
