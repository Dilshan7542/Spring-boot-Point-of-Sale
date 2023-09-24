package org.thogakade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
   private String customerID;
   private String name;
   private String email;
   private String phone;
   private double salary;
}
