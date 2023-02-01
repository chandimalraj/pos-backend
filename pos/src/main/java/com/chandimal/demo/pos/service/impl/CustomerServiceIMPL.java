package com.chandimal.demo.pos.service.impl;
import com.chandimal.demo.pos.dto.CustomerDTO;
import com.chandimal.demo.pos.dto.request.CustomerUpdateDTO;
import com.chandimal.demo.pos.entity.Customer;
import com.chandimal.demo.pos.repo.CustomerRepo;
import com.chandimal.demo.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {

        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){

            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setNic(customerUpdateDTO.getNic());
            customerRepo.save(customer);
            return "updated";

        }
        else{
            throw new RuntimeException("no data found for this id");
        }


    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        }else{
            throw new RuntimeException("No Customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers  = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );

            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted successfully " + customerId;
        }else {
            throw new RuntimeException("not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveStatus(boolean activeStatus) {
        List<Customer> customers = customerRepo.findByActiveEquals(activeStatus);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );

            customerDTOList.add(customerDTO);
        }
        return customerDTOList;

    }
}
