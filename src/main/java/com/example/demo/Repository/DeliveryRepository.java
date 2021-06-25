package com.example.demo.Repository;

import com.example.demo.DeliveryandPlantDTO.RecipientAndPriceDTO;
import com.example.demo.entity.Delivery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository {
    void persist(Delivery delivery);
    Delivery find(Long id);
    Delivery merge(Delivery delivery);
    void delete(Long id);
    List<Delivery> getDeliveries(String name);
    RecipientAndPriceDTO findRecipeientAndPrice(Long deliveryId);
}
