package com.example.cardapio.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired

    private FoodRepository repository;

    public List<FoodResponseDTO> listAll(){
        return repository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    public FoodResponseDTO save(FoodRequestDTO data){
        Food food = new Food(data);
        repository.save(food);
        return new FoodResponseDTO(food);
    }

    public FoodResponseDTO update(long id, FoodRequestDTO data){
        Food food = repository.findById(id).orElseThrow(() -> new RuntimeException("Food not found"));
        food.setTitle(data.title());
        food.setImage(data.image());
        food.setPrice(data.price());
        repository.save(food);

        return new FoodResponseDTO(food);

    }

    public void delete(long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Food not found");
        }
        repository.deleteById(id);
    }


}
