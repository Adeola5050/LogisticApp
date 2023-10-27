package com.geobyte_assement.Geobyte_Assement.controller;

import com.geobyte_assement.Geobyte_Assement.dto.AddLocationDto;
import com.geobyte_assement.Geobyte_Assement.dto.RegisterUser;
import com.geobyte_assement.Geobyte_Assement.dto.UpdateLocationDto;
import com.geobyte_assement.Geobyte_Assement.model.DeliveryLocation;
import com.geobyte_assement.Geobyte_Assement.model.User;
import com.geobyte_assement.Geobyte_Assement.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logistic")
public class LogisticController{

    @Autowired
   private DeliveryService deliveryService;


    @PostMapping("/addLocation")
    public ResponseEntity<DeliveryLocation> addLocation(@RequestBody AddLocationDto dto) {
        deliveryService.addLocation(dto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }

    @GetMapping("/viewLocations")
    public ResponseEntity<List<DeliveryLocation>> viewLocations(){
        List<DeliveryLocation> locations=deliveryService.viewLocations();
        return new ResponseEntity<>(locations,HttpStatus.OK);
    }

    @PutMapping("/updateLocation/{deliveryLocationId}")
    public ResponseEntity<DeliveryLocation> updateLocation(DeliveryLocation location)  {
        DeliveryLocation updateLocation= deliveryService.updateDeliveryLocation(location);
        return new ResponseEntity<>(updateLocation,HttpStatus.OK);
    }

    @DeleteMapping("/removeLocation/{id}")
    public ResponseEntity<?> removeLocation(@PathVariable("id") Long id){
        deliveryService.removeLocation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUser dto){
       User user= deliveryService.register(dto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/findByLocationId{Id}")
    public ResponseEntity<?> FindLocationById(@PathVariable Long locationId) {
        deliveryService.findById(locationId);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
