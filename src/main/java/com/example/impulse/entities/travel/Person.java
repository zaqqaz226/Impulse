package com.example.impulse.entities.travel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "travel_id",
            nullable = false
    )
    public Travel travel;
}
