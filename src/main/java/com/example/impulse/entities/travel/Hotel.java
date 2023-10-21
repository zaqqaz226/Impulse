package com.example.impulse.entities.travel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "name")
    public String name;
}
