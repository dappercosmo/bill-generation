package com.trial.billGeneration.controller;

import com.trial.billGeneration.model.Customer;
import com.trial.billGeneration.model.Orders;
import com.trial.billGeneration.model.Product;
import com.trial.billGeneration.requests.OrderRequest;
import com.trial.billGeneration.service.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders/v1")
public class OrdersController {
    private final OrdersService ordersService;
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @PostMapping("/create")
    ResponseEntity<OrderRequest> createOrders(@RequestBody OrderRequest orderRequest){
        ordersService.createOrders(
                orderRequest.getCustomerName(),
                orderRequest.getPhone(),
                orderRequest.getProductId(),
                orderRequest.getQuantity()
        );
        return ResponseEntity.ok(orderRequest);
    }
}
