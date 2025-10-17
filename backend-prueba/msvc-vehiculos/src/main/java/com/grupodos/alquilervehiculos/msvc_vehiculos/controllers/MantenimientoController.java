package com.grupodos.alquilervehiculos.msvc_vehiculos.controllers;

import com.grupodos.alquilervehiculos.msvc_vehiculos.dto.MantenimientoRequestDto;
import com.grupodos.alquilervehiculos.msvc_vehiculos.entities.Mantenimiento;
import com.grupodos.alquilervehiculos.msvc_vehiculos.services.MantenimientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class MantenimientoController {
    private final MantenimientoService mantenimientoService;

    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }

    // Listar todos los mantenimientos
    @GetMapping
    public List<Mantenimiento> listar() {
        return mantenimientoService.listarTodos();
    }

    // Obtener mantenimiento por ID
    @GetMapping("/{id}")
    public Mantenimiento obtener(@PathVariable Long id) {
        return mantenimientoService.obtenerPorId(id);
    }

    // Crear mantenimiento (cambia estado a MANTENIMIENTO)
    @PostMapping
    public Mantenimiento crear(@RequestBody MantenimientoRequestDto dto) {
        return mantenimientoService.crearMantenimiento(dto);
    }

    // Finalizar mantenimiento (cambia estado a DISPONIBLE)
    @PutMapping("/{id}/finalizar")
    public Mantenimiento finalizar(@PathVariable Long id) {
        return mantenimientoService.finalizarMantenimiento(id);
    }

    // Eliminar mantenimiento
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        mantenimientoService.eliminarMantenimiento(id);
    }

    // Listar mantenimientos por vehículo
    @GetMapping("/vehiculo/{vehiculoId}")
    public List<Mantenimiento> listarPorVehiculo(@PathVariable UUID vehiculoId) {
        return mantenimientoService.listarPorVehiculo(vehiculoId);
    }
}
