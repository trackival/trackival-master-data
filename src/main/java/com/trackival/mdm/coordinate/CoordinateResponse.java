package com.trackival.mdm.coordinate;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CoordinateResponse {
    @Builder.Default
    private List<CoordinateResult> data = new ArrayList<>();
}
