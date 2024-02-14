package org.thogakade.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thogakade.entity.Item;
import org.thogakade.entity.Orders;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailDTO {
   private String itemCode;
   private String orderID;
   private int qty;
   private double unitPrice;
   private int discount;
}
