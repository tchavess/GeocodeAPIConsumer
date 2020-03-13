package br.com.geocoding.geocodeconsumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.omg.PortableInterceptor.LOCATION_FORWARD;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
@RequestMapping("/geocoding-api")
public class GeocodingAPI {

        @GetMapping("/location")
        public Location printApi() throws InterruptedException, ApiException, IOException {
            Location location = new Location();
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey("AIzaSyADxZ2DfcGkasFIjsXIL6RgT5kJIYzqokw")
                    .build();
            GeocodingResult[] results =  GeocodingApi.geocode(context,
                    "R. Figueiredo Rocha 896, Vigario Geral").await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(results[0].geometry.location.lat));
            System.out.println(gson.toJson(results[0].geometry.location.lng));
            location.setLat(results[0].geometry.location.lat);
            location.setLng(results[0].geometry.location.lng);


            return location;
        }



}
