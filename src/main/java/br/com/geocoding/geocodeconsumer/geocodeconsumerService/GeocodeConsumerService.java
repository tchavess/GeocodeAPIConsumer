package br.com.geocoding.geocodeconsumer.geocodeconsumerService;

import br.com.geocoding.geocodeconsumer.LocationRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.LocationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.xml.stream.Location;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeocodeConsumerService {
private static final Logger logger = LoggerFactory.getLogger(GeocodeConsumerService.class);
    public List<LatLng> obterGeolocation(List<String> request, String key) {
        Locations loc = new Locations();
        List<LatLng> locList = new  ArrayList<>();
        try {
            for(int i = 0; i < request.size(); i++) {
                int index = 0;

                GeoApiContext context = new GeoApiContext.Builder()
                        .apiKey(key)
                        .build();
                GeocodingResult[] results = GeocodingApi.geocode(context,
                        request.get(i)).await();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                System.out.println(gson.toJson(results[index].geometry.location.lat));
                System.out.println(gson.toJson(results[index].geometry.location.lng));
                locList.add(results[index].geometry.location);

                index += 1;

            }

        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ApiException ex){
            ex.printStackTrace();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }finally {
            //logger.info("LOCATION: " + location);
            logger.info("LOC: " + loc.toString());
        }

        return locList;
    }
}

