package com.trackival.service.user.dto;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBiographyInput {
    private UUID id;
    private String biography;
}
