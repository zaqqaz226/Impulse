package com.example.impulse.entities.travel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "city_name")
    String cityName;

    @OneToOne(mappedBy = "country")
    public Travel travel;
}
