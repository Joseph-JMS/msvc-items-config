package com.grupodos.alquilervehiculos.msvc_vehiculos.controllers;

import com.grupodos.alquilervehiculos.msvc_vehiculos.dto.VehiculoRequestDto;
import com.grupodos.alquilervehiculos.msvc_vehiculos.entities.Vehiculo;
import com.grupodos.alquilervehiculos.msvc_vehiculos.services.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "http://localhost:3000")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> listar() {
        return vehiculoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtener(@PathVariable UUID id) {
        return ResponseEntity.ok(vehiculoService.obtenerPorId(id));
    }

    @PostMapping
    public Vehiculo guardar(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.guardar(vehiculo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable UUID id) {
        vehiculoService.eliminar(id);
    }

}
