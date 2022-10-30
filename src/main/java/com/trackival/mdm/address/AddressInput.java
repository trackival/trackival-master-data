package com.trackival.mdm.address;

import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressInput {
    private String street;
    private String houseNumber;
    private String zipCode;
    private String town;
    private String country;
}
