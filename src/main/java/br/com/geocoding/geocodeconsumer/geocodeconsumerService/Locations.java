package br.com.geocoding.geocodeconsumer.geocodeconsumerService;

import com.google.maps.model.LatLng;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Locations {
    private LatLng[] location;
}
