package com.geobyte_assement.Geobyte_Assement.service;

import com.geobyte_assement.Geobyte_Assement.dto.AddLocationDto;
import com.geobyte_assement.Geobyte_Assement.dto.RegisterUser;
import com.geobyte_assement.Geobyte_Assement.exception.UserNotFoundException;
import com.geobyte_assement.Geobyte_Assement.model.DeliveryLocation;
import com.geobyte_assement.Geobyte_Assement.model.DeliveryRoute;
import com.geobyte_assement.Geobyte_Assement.model.User;
import com.geobyte_assement.Geobyte_Assement.repositories.DeliveryLocationRepo;
import com.geobyte_assement.Geobyte_Assement.repositories.DeliveryRouteRepo;
import com.geobyte_assement.Geobyte_Assement.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryLocationRepo deliveryLocationRepo;

    @Autowired
    private DeliveryRouteRepo deliveryRouteRepo;
    @Autowired
    private UserRepo userRepo;

    private List<DeliveryLocation> locations = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<DeliveryRoute> routes = new ArrayList<>();


    @Override
    public User register(RegisterUser dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        userRepo.save(user);


        return user;
    }

    @Override
    public void addLocation(AddLocationDto dto) {
        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setName(dto.getName());
        deliveryLocation.setLatitude(dto.getLatitude());
        deliveryLocation.setLongitude(dto.getLongitude());
        deliveryLocationRepo.save(deliveryLocation);

    }

    @Override
    public DeliveryLocation removeLocation(long id) {
        deliveryLocationRepo.deleteById(id);

        return null;
    }

    @Override
    public List<DeliveryLocation> viewLocations() {
        return (List<DeliveryLocation>) deliveryLocationRepo.findAll();
    }

    @Override
    public DeliveryLocation updateDeliveryLocation(DeliveryLocation location) {
        return deliveryLocationRepo.save(location);
    }

    @Override
    public DeliveryLocation findById(Long id) {
        return deliveryLocationRepo.findById(id).orElseThrow(() ->
                new UserNotFoundException("id does not exist in the database"));
    }

    DeliveryLocation getLocation(Long id) {
        return deliveryLocationRepo.findById(id).orElseThrow(() ->
                new UserNotFoundException("id cannot be null"));

    }


}
