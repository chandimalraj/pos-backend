package com.chandimal.demo.pos.controller;

import com.chandimal.demo.pos.dto.CustomerDTO;
import com.chandimal.demo.pos.dto.request.CustomerUpdateDTO;
import com.chandimal.demo.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        customerService.updateCustomer(customerUpdateDTO);
        return "updated";
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
       CustomerDTO customerDTO = customerService.getCustomerById(customerId);
       return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path = "/delete/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }

    @GetMapping(
            path = "/get-all-customers-by-active-status/{status}"
    )
    public List<CustomerDTO> getAllCustomersByActiveStatus(@PathVariable(value = "status") boolean activeStatus){
        List<CustomerDTO> allCustomersByActiveStatus = customerService.getAllCustomersByActiveStatus(activeStatus);
        return allCustomersByActiveStatus;
    }

}
