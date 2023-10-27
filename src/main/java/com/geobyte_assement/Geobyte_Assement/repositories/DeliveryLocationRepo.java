package com.geobyte_assement.Geobyte_Assement.repositories;

import com.geobyte_assement.Geobyte_Assement.model.DeliveryLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryLocationRepo extends JpaRepository<DeliveryLocation, Long> {
    boolean existsByNameIgnoreCase(String name);

    @Override
    void deleteById(Long aLong);
}
