package br.com.geocoding.geocodeconsumer.config;

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
            this.key_code = "AIzaSyBilyty48TJT0dGayaMkKicX6VIPjGzzWA";
        }
}
