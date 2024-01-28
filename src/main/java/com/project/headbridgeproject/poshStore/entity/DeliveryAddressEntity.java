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
@Table(name = "delivery_addresses")
public class DeliveryAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "postcode", nullable = false)
    private String postcode;

    @ManyToMany(mappedBy = "deliveryAddresses")
    private List<OrderEntity> orders;

    @ManyToMany
    @JoinTable(name = "delivery_address_regions",
            joinColumns = @JoinColumn(name = "delivery_address_id"),
            inverseJoinColumns = @JoinColumn(name = "region_id"))
    public List<DeliveryRegionEntity> regionId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    public DeliveryCountryEntity countryId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    public DeliveryCityEntity cityId;

    @OneToOne(mappedBy = "address")
    public CartOfOrderEntity cartOfOrderEntity;
}
