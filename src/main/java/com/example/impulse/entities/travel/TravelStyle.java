package com.example.impulse.entities.travel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "travel_style")
public enum TravelStyle {
    ON_VEHICLE
    ,FREE
    ,WILD
    ,LUX
    ,ECONOM
}
