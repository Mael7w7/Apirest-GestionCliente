package com.ahc.gestionClientes.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private String name;
    private String email;
    private String phone;

}
