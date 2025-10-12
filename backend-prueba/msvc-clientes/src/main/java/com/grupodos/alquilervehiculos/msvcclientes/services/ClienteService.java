package com.grupodos.alquilervehiculos.msvcclientes.services;

import com.grupodos.alquilervehiculos.msvcclientes.entities.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteService {

    List<Cliente> findAll();
    Optional<Cliente> findById(UUID id);
    Cliente save(Cliente cliente);
}
