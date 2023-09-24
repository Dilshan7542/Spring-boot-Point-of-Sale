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
public class OrderDetail{
    @Id
    @ManyToOne
    @JoinColumn(name = "orderID")
   Orders orders;
   @Id
    @ManyToOne
    @JoinColumn(name = "itemCode123")
    Item item;
    private int qty;
    private double unitPrice;
    private int discount;
}
