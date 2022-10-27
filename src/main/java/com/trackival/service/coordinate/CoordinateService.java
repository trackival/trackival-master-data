package com.trackival.service.coordinate;

import com.trackival.service.address.Address;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoordinateService {
    @Value("${trackival.coordinate.api.key}")
    private String key;

    @Value("${trackival.coordinate.api.url}")
    private String url;

    public CoordinateResult findCoordinate(Address address) {
        final String uri = this.url
                .replace("%API_KEY%", this.key)
                .replace("%QUERY%", address.toFormattedString());
        final RestTemplate template = new RestTemplate();
        final CoordinateResponse response = template.getForObject(uri, CoordinateResponse.class);
        if (response == null || response.getData() == null || response.getData().isEmpty()) {
            return null;
        }
        return response.getData().get(0);
    }
}
