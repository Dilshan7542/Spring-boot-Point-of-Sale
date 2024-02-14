package org.thogakade.entity;

import jakarta.persistence.Id;

import java.io.Serializable;

public class OrderDetail_PK implements Serializable {
    private String itemCode;
    private String orderID;
}
