package com.ahc.gestionClientes.services;

import com.ahc.gestionClientes.dtos.CustomerDTO;
import com.ahc.gestionClientes.entities.CustomersEntity;
import com.ahc.gestionClientes.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CustomerService implements  ICustomerService{
    //INYECTION DEPENDENCY
    private final CustomerRepository repository;

    @Override
    public CustomersEntity addCustomer(CustomersEntity customer) {
        return repository.save(customer);
    }


    @Override
    public List<CustomerDTO> findAllCustomers() {

        return repository.findAll()
                .stream()
                .map(r-> new CustomerDTO(r.getName(),r.getEmail(),r.getPhone()))
                .collect(Collectors.toList());
    }


    @Override
    public CustomerDTO findCustomerById(Long id) {

        return repository.findById(id)
                .map(r -> new CustomerDTO(r.getName(),r.getEmail(),r.getPhone()))
                .orElse(null);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customer) {
        return repository.findById(id)
                .map(existing->{
                    existing.setName(customer.getName());
                    existing.setEmail(customer.getEmail());
                    existing.setPhone(customer.getPhone());
                    CustomersEntity update = repository.save(existing);
                    return new CustomerDTO(update.getName(),update.getEmail(),update.getPhone()
                    );
                }).orElse(null);

    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
