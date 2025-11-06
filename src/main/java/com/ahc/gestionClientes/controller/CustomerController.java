package com.ahc.gestionClientes.controller;

import com.ahc.gestionClientes.dtos.CustomerDTO;
import com.ahc.gestionClientes.entities.CustomersEntity;
import com.ahc.gestionClientes.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor

public class CustomerController {
    //inyection dependency
    private final CustomerService customerService;


    @PostMapping
    public CustomersEntity createCustomer( @RequestBody CustomersEntity customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<CustomerDTO> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PutMapping("/{id}")
    public  CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customer) {
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
