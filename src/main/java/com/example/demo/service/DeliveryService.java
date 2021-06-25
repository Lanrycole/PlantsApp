package com.example.demo.service;


import com.example.demo.DeliveryandPlantDTO.RecipientAndPriceDTO;
import com.example.demo.Repository.DeliveryRepository;
import com.example.demo.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }


    public RecipientAndPriceDTO getBill(Long deliveryId) {
        return deliveryRepository.findRecipeientAndPrice(deliveryId);
    }

    public List<Delivery> deliveryList(String name){

        System.out.println("Inside Service"+ deliveryRepository.getDeliveries(name));
        return deliveryRepository.getDeliveries(name);

    }
}
