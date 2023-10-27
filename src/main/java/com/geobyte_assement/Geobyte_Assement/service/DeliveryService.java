package com.geobyte_assement.Geobyte_Assement.service;

import com.geobyte_assement.Geobyte_Assement.dto.AddLocationDto;
import com.geobyte_assement.Geobyte_Assement.dto.RegisterUser;
import com.geobyte_assement.Geobyte_Assement.model.DeliveryLocation;
import com.geobyte_assement.Geobyte_Assement.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DeliveryService   {

    User register(RegisterUser dto);


    void addLocation(AddLocationDto dto);
    void removeLocation(long id);

    List<DeliveryLocation> viewLocations();
    DeliveryLocation updateDeliveryLocation(DeliveryLocation location) ;

    DeliveryLocation findById(Long id) ;



}
