package com.example.myrealestate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String title;
    @Column
    @Enumerated(value = EnumType.STRING)
    private PropertyType propertyType;
    @Column
    private double price;
    @Column
    private int bedrooms;
    @Column
    private int bathrooms;
    @Column
    private double area;
    @Column
    private String mlsNo;
    @Column
    private String location;
  /* @ManyToMany
    @JoinTable(name = "property_features",
            joinColumns = {@JoinColumn(name = "property_id")},
            inverseJoinColumns = {@JoinColumn(name = "feature_id") })
    private List<PropertyFeatures> featureProperty;*/
    @Column
    private String picUrl;

}
