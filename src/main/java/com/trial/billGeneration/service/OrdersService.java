package com.trial.billGeneration.service;

import com.trial.billGeneration.model.Customer;
import com.trial.billGeneration.model.Orders;
import com.trial.billGeneration.model.Product;

public interface OrdersService {
    Orders createOrders(String customerName, String phone, long productId, long quantity);
}
