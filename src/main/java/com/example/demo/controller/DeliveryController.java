package com.example.demo.controller;


import com.example.demo.DeliveryandPlantDTO.RecipientAndPriceDTO;
import com.example.demo.entity.Delivery;
import com.example.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {


    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPriceDTO getBill( @PathVariable Long deliveryId){
      return deliveryService.getBill(deliveryId);
    }

    @GetMapping("/{name}")
    public List<Delivery> deliveryList(@PathVariable  String name){
        return deliveryService.deliveryList(name);
    }
}
