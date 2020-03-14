package br.com.geocoding.geocodeconsumer.geocodeconsumerService;

import br.com.geocoding.geocodeconsumer.Location;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class GeocodeConsumerService {

    public Location obterGeolocation(String address, String key) throws InterruptedException, ApiException, IOException {

        Location location = new Location();
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(key)
                .build();
        GeocodingResult[] results =  GeocodingApi.geocode(context,
                address).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(results[0].geometry.location.lat));
        System.out.println(gson.toJson(results[0].geometry.location.lng));
        location.setLat(results[0].geometry.location.lat);
        location.setLng(results[0].geometry.location.lng);

        return location;
    }
}
