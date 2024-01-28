package com.project.headbridgeproject.poshStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class DeliveryAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "description", nullable = false)
    public String description;
    @Column(name = "postcode", nullable = false)
    public String postcode;

    public List<DeliveryRegions> regionId;
    public List<DeliveryCountries> countryId;
    public List<DeliveryCities> cityId;
}
