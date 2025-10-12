package com.grupodos.alquilervehiculos.msvcclientes.services;

import com.grupodos.alquilervehiculos.msvcclientes.entities.Cliente;
import com.grupodos.alquilervehiculos.msvcclientes.repositories.ClienteRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        cliente.setCreadoEn(OffsetDateTime.now());
        return clienteRepository.save(cliente);
    }
}
