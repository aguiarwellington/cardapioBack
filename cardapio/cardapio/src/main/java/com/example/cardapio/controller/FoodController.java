package com.example.cardapio.controller;

import com.example.cardapio.food.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    private FoodService service;

    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        service.save(data);
    }

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return service.listAll();
    }

    @PutMapping("/{id}")
    public FoodResponseDTO update(@PathVariable Long id, @RequestBody FoodRequestDTO data) {
        return service.update(id, data);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
