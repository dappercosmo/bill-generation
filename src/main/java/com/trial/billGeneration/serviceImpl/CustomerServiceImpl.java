package com.trial.billGeneration.serviceImpl;

import com.trial.billGeneration.exception.CustomerAlreadyPresentException;
import com.trial.billGeneration.model.Customer;
import com.trial.billGeneration.repository.CustomerRepository;
import com.trial.billGeneration.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
//        Customer existingCustomer = customerRepository.findByPhone(customer.getPhone());
//        if(existingCustomer != null){
            Customer newCustomer = new Customer();
            newCustomer.setName(customer.getName());
            newCustomer.setPhone(customer.getPhone());
            newCustomer.setCreatedAt(new Date());
            newCustomer.setUpdatedAt(new Date());
            newCustomer.setDeleted(false);
            return customerRepository.save(newCustomer);
//        }else {
//            throw new CustomerAlreadyPresentException("customer with {} phone number already exists",customer.getPhone());
//        }
    }


}
