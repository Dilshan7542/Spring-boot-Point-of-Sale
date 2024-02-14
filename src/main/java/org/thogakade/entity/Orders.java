package org.thogakade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orders implements Serializable {
    @Id
    private String orderID;
    private LocalDate date;
    private LocalTime time;
    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders",  fetch = FetchType.EAGER,orphanRemoval = true)
    private List<OrderDetail> orderDetailList;

    public Orders(String orderID) {
        this.orderID = orderID;
    }
}
