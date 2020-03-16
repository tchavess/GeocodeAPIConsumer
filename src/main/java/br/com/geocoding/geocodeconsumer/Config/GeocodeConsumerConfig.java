package br.com.geocoding.geocodeconsumer.Config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GeocodeConsumerConfig {
    //API KEY do Google
    private String key_code;

        public GeocodeConsumerConfig() {
            this.key_code = "AIzaSyADxZ2DfcGkasFIjsXIL6RgT5kJIYzqokw";
        }
}
