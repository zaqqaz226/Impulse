package com.example.impulse.entities.travel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "country")
public class PhotosLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "link")
    public String link;

}
