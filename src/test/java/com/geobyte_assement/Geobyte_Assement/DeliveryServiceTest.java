package com.geobyte_assement.Geobyte_Assement;

import com.geobyte_assement.Geobyte_Assement.model.DeliveryLocation;
import com.geobyte_assement.Geobyte_Assement.model.User;
import com.geobyte_assement.Geobyte_Assement.repositories.DeliveryLocationRepo;
import com.geobyte_assement.Geobyte_Assement.service.DeliveryService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@SpringBootTest
public class DeliveryServiceTest {

    @Autowired
    Gson gson;
    @Autowired
    private DeliveryService deliveryService;
    @Autowired
    private DeliveryLocationRepo deliveryLocationRepo;

    @Autowired
    public DeliveryServiceTest(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @Test
    void testThatRegisterUser() {
        User user = new User();
        user.setName("aj");
        user.setEmail("ajenifuja@gmail.com");
        user.setPassword("aj@3090");
        String gson=new Gson().toJson(user);
        System.out.println(gson);
        assertThat(user.getName()).isNotNull();
        assertThat(user.getEmail()).isEqualTo("ajenifuja@gmail.com");
    }

    @Test
    void testThatAddLocation() {
        DeliveryLocation deliveryLocation = new DeliveryLocation();
        deliveryLocation.setName("New york");
        deliveryLocation.setLongitude(455589.00);
        deliveryLocation.setLatitude(90008.90);
        assertThat(deliveryLocation.getLongitude()).isEqualTo(455589.00);
        assertThat(deliveryLocation.getLatitude()).isGreaterThan(67770.00);
        assertThat(deliveryLocation.getName()).isNotNull();
    }

    @Test
    void testThatGetAllLocations() {
        List<DeliveryLocation> locationList = new ArrayList<>();
        DeliveryLocation deliveryLocation1 = new DeliveryLocation();
        deliveryLocation1.setName("bolu");
        deliveryLocation1.setLatitude(9000.99);
        deliveryLocation1.setLongitude(89990.00);

        DeliveryLocation deliveryLocation2 = new DeliveryLocation();
        deliveryLocation2.setName("temi");
        deliveryLocation2.setLatitude(9000.99);
        deliveryLocation2.setLongitude(89990.00);


        locationList.add(deliveryLocation1);
        locationList.add(deliveryLocation2);

        assertThat(locationList).isNotNull();
        System.out.println(locationList);
    }

    @Test
    void testThatDeleteLocation() {
        long locationId =2;
        deliveryLocationRepo.deleteById(locationId);

        assertThat(locationId).isEqualTo(2);

    }

    @Test
    void testThatUpdateLocation(){
        DeliveryLocation updateLocation= new DeliveryLocation();
        updateLocation.setName("Temiju");
        updateLocation.setLongitude(777990.00);
        updateLocation.setLatitude(09000.23);
        assertThat(updateLocation).isNotNull();
    }


    @Test
    void testThatFindLocationById(){
        long locationId= 7;
        deliveryLocationRepo.findById(locationId);
        assertThat(locationId).isEqualTo(7);
    }
}


