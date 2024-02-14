package org.thogakade.service.impl;

import jakarta.persistence.EntityManager;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thogakade.dto.OrderDetailDTO;
import org.thogakade.dto.OrdersDTO;

import org.thogakade.entity.Customer;
import org.thogakade.entity.Item;
import org.thogakade.entity.OrderDetail;
import org.thogakade.entity.Orders;
import org.thogakade.repo.OrderDetailsRepo;
import org.thogakade.repo.OrdersRepo;
import org.thogakade.service.PurchaseOrderService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    ModelMapper mapper;



    @Override
    public OrdersDTO savePurchaseOrder(OrdersDTO ordersDTO) {
       /* if (ordersRepo.existsById(ordersDTO.getOrderID())) {
            throw new RuntimeException("Order is already exists..!");
        }*/
        Orders orders = new Orders();
        orders.setOrderID("D001");
        orders.setCustomer(new Customer("C001"));
        orders.setDate(LocalDate.now());
        orders.setTime(LocalTime.now());

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderID("D001");
        orderDetail.setItemCode("P001");
        orderDetail.setQty(1);
        orderDetail.setDiscount(10);
        orderDetail.setUnitPrice(25.00);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setOrderID("D001");
        orderDetail2.setItemCode("P002");
        orderDetail2.setQty(1);
        orderDetail2.setDiscount(10);
        orderDetail2.setUnitPrice(25.00);

        ArrayList<OrderDetail> list = new ArrayList<>();
        list.add(orderDetail);
        list.add(orderDetail2);
        orders.setOrderDetailList(list);

        ordersRepo.save(orders);
         return ordersDTO;
    }

    @Override
    public OrdersDTO updatePurchaseOrder(OrdersDTO ordersDTO) {
        if (!ordersRepo.existsById(ordersDTO.getOrderID())) {
            throw new RuntimeException("Order is not exists..!");
        }
        ordersRepo.save(mapper.map(ordersDTO, Orders.class));
        return ordersDTO;
    }

    @Override
    public boolean deletePurchaseOrder(String id) {
        if (!ordersRepo.existsById(id)) {
            throw new RuntimeException("Order is not exists..!");
        }
        ordersRepo.deleteById(id);
        return !ordersRepo.existsById(id);
    }

    @Override
    public OrdersDTO searchPurchaseOrder(String id) {
        if (!ordersRepo.existsById(id)) {
            throw new RuntimeException("Order is not exists..!");
        }
        return mapper.map(ordersRepo.findById(id).get(),OrdersDTO.class);
    }

    @Override
    public List<OrdersDTO> getAllPurchaseOrder() {
        return mapper.map(ordersRepo.findAll(),new TypeToken<List<OrdersDTO>>(){}.getType());
    }
}
