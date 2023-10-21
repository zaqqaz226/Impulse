package com.example.impulse.entities.travel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name = "travel")
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "days_in_travel")
    public Integer daysInTravel;

    @Column(name = "road_budget")
    public Double budgetForRoad;

    @Column(name = "accommodation_budget")
    public Double budgetForAccommodation;

    @Column(name = "travel_style")
    @Enumerated(EnumType.STRING)
    public TravelStyle travelStyle;


    @CreationTimestamp
    public LocalDateTime dateCreated;

    @UpdateTimestamp
    public LocalDateTime dateUpdate;

    @OneToOne
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "id"
    )
    public Country country;

    @OneToOne
    @JoinColumn(
            name = "city_id",
            referencedColumnName = "id"
    )
    public City city;

    @OneToMany(
            mappedBy = "travel",
            cascade = {
                    CascadeType.MERGE,
                    CascadeType.PERSIST
            }
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public List<FamousPlaces> placesList;

    @OneToMany(
            mappedBy = "travel",
            cascade = CascadeType.ALL
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public List<Person> personsList;

/*    @OneToMany
    public List<PhotosLinks> photosLinksList;

    @OneToMany
    public List<Hotel> hotelList;*/
}
