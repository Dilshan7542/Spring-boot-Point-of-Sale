package org.thogakade.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Serializable {
   @Id
   private String itemCode;
   private String description;
   private int qty;
   private double unitPrice;
   @ToString.Exclude
   @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
  private List<OrderDetail> orderDetailList;

   public Item(String itemCode) {
      this.itemCode = itemCode;
   }
}
