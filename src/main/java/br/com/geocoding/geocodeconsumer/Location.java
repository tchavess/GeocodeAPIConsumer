package br.com.geocoding.geocodeconsumer;

import com.google.maps.internal.StringJoin;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@Getter
@Setter
@ToString
public class Location implements StringJoin.UrlValue, Serializable {
    private static final long serialVersionUID = 1L;
        public double lat;
        public double lng;

    @Override
    public String toUrlValue() {
        return null;
    }
}
