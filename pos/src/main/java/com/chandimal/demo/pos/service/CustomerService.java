package com.chandimal.demo.pos.service;

import com.chandimal.demo.pos.dto.CustomerDTO;
import com.chandimal.demo.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {

    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus);
}
