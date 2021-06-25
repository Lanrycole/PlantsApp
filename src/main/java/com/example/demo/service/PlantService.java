package com.example.demo.service;

import com.example.demo.Repository.PlantRepository;
import com.example.demo.entity.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;


    public Long save(Plant plant){
       return plantRepository.save(plant).getId();

    }

    public boolean delivered(Long id){
        return plantRepository.existsPlantByIdAndDeliveryCompleted(id, true);
    }

    public List<Plant> findPlantsBelowPrice(BigDecimal price) {
        return plantRepository.findByPriceLessThan(price);
    }

    public Plant getPlantByName(String name){
        return new Plant();
    }
}
