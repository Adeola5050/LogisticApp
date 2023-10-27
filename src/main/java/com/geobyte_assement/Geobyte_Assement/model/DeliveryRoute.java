package com.geobyte_assement.Geobyte_Assement.model;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class DeliveryRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(
            mappedBy = "id",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = true
    )    private List<DeliveryLocation> routes;
    private double cost;



//    public DeliveryRoute calculateOptimalRoute(String origin,String destination){

//       return
//    }

}
