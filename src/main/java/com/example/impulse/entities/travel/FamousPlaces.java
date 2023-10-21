package com.example.impulse.entities.travel;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "famous_places")
public class FamousPlaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @OneToOne
    public Country country;

    @OneToOne
    public City city;

    @Column(name = "short_description")
    public String shortDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "travel_id",
            nullable = false
    )
    public Travel travel;
}
