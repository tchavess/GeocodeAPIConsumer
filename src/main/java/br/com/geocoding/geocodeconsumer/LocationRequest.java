package br.com.geocoding.geocodeconsumer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class LocationRequest {
    private List<String> address;

    public LocationRequest(List<String> address){
        this.address = address;
    }
}
