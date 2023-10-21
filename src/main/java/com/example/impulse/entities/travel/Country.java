package com.example.impulse.entities.travel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "country_name")
    String countryName;

    @OneToOne(mappedBy = "country")
    public Travel travel;
}
