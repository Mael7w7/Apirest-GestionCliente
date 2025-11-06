package com.ahc.gestionClientes.repositories;

import com.ahc.gestionClientes.entities.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<CustomersEntity, Long> {

}
