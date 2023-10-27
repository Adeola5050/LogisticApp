package com.geobyte_assement.Geobyte_Assement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DeliveryLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double latitude;
    private double longitude;

    public DeliveryLocation(){

    }
    public DeliveryLocation(Long id, String name, double latitude, double longitude){
        this.id=id;
        this.name=name;
        this.latitude=latitude;
        this.longitude=longitude;

    }



}
