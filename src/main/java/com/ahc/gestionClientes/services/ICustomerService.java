package com.ahc.gestionClientes.services;

import com.ahc.gestionClientes.dtos.CustomerDTO;
import com.ahc.gestionClientes.entities.CustomersEntity;

import java.util.List;

public interface ICustomerService {
    CustomersEntity addCustomer(CustomersEntity customer);
    List<CustomerDTO> findAllCustomers();
    CustomerDTO findCustomerById(Long id);
    CustomerDTO updateCustomer(Long id, CustomerDTO customer);
    void deleteCustomer(Long id);


}
