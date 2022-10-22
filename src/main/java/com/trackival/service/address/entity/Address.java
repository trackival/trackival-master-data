package com.trackival.service.address.entity;

import com.trackival.service.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Address extends BaseEntity {

    @NotNull
    @Column(nullable = false)
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @NotNull
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @NotNull
    @Column(nullable = false)
    private String town;

    @NotNull
    private String country;

    public Address merge(Address address) {
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        this.zipCode = address.getZipCode();
        this.town = address.getTown();
        this.country = address.getCountry();
        return this;
    }
}