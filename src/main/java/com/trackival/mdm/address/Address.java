package com.trackival.mdm.address;

import com.trackival.mdm.common.BaseEntity;
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
@ToString(callSuper = true)
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

    @NotNull
    @Builder.Default
    @Column(nullable = false, precision = 6, scale = 2)
    private double longitude = 0.0;

    @NotNull
    @Builder.Default
    @Column(nullable = false, precision = 6, scale = 2)
    private double latitude = 0.0;

    public String toFormattedString() {
        return String.format("%s %s, %s %s %s", this.street, this.houseNumber, this.zipCode, this.town, this.country);
    }
}
