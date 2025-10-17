package com.grupodos.alquilervehiculos.msvc_vehiculos.controllers;

import com.grupodos.alquilervehiculos.msvc_vehiculos.entities.Modelo;
import com.grupodos.alquilervehiculos.msvc_vehiculos.services.ModeloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> listar() {
        return modeloService.listar();
    }

    @GetMapping("/marca/{idMarca}")
    public List<Modelo> listarPorMarca(@PathVariable Long idMarca) {
        return modeloService.listarPorMarca(idMarca);
    }

    @PostMapping
    public Modelo guardar(@RequestBody Modelo modelo) {
        return modeloService.guardar(modelo);
    }

}
