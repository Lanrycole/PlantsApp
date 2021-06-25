package com.example.demo.service;

import com.example.demo.DeliveryandPlantDTO.RecipientAndPriceDTO;
import com.example.demo.Repository.DeliveryRepository;
import com.example.demo.entity.Delivery;
import com.example.demo.entity.Plant;
 import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;




@Transactional
@Repository
public class DeliveryRepoImpl implements DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void persist(Delivery delivery) {
        entityManager.persist(delivery);

    }

    @Override
    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    @Override
    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    @Override
    public void delete(Long id) {
        Optional<Delivery> findDeliveryID =
                Optional.ofNullable
                        (entityManager.find(Delivery.class, id));

        if (findDeliveryID.isPresent()) {
            entityManager.remove(id);
        }

    }

    @Override
    public List<Delivery> getDeliveries(String name) {
        TypedQuery<Delivery> typedQuery = entityManager.createNamedQuery("Delivery.findByName",
                Delivery.class);
        typedQuery.setParameter("name", name);
        System.out.println("printing results: " + typedQuery.getResultList());
        return typedQuery.getResultList();
    }


    @Override
    public RecipientAndPriceDTO findRecipeientAndPrice(Long deliveryId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPriceDTO> criteria = cb.createQuery(RecipientAndPriceDTO.class);
        Root<Plant> root = criteria.from(Plant.class);
        criteria.select(
                cb.construct(
                        RecipientAndPriceDTO.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));
        return entityManager.createQuery(criteria).getSingleResult();

    }
}
