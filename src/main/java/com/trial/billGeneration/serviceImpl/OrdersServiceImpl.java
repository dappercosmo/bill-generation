package com.trial.billGeneration.serviceImpl;

import com.trial.billGeneration.model.Customer;
import com.trial.billGeneration.model.Orders;
import com.trial.billGeneration.model.Product;
import com.trial.billGeneration.repository.CustomerRepository;
import com.trial.billGeneration.repository.OrdersRepository;
import com.trial.billGeneration.repository.ProductRepository;
import com.trial.billGeneration.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    public OrdersServiceImpl(OrdersRepository ordersRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Orders createOrders(String customerName, String phone, long productId, long quantity) {
        Optional<Customer> custoemrOptional = customerRepository.findByPhone(phone);
        Customer customer;

        if(custoemrOptional.isPresent()){
            customer = custoemrOptional.get();
        }else {
            customer = new Customer();
            customer.setName(customerName);
            customer.setPhone(phone);
            customer.setCreatedAt(new Date());
            customer.setUpdatedAt(new Date());
            customer.setDeleted(false);
            customer = customerRepository.save(customer);
        }

        Product product = productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        long totalPrice = product.getPrice() * quantity;

        Orders orders = new Orders();
        orders.setCustomer(customer);
        orders.setProduct(product);
        orders.setQuantity(quantity);
        orders.setTotalPrice(totalPrice);
        orders.setCreatedAt(new Date());
        orders.setUpdatedAt(new Date());
        orders.setDeleted(false);
        return ordersRepository.save(orders);
    }
}
