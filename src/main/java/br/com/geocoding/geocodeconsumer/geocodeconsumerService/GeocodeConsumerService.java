package br.com.geocoding.geocodeconsumer.geocodeconsumerService;

import br.com.geocoding.geocodeconsumer.Beans.GeocodeConsumerResponse;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeocodeConsumerService {

    public GeocodeConsumerResponse obterGeolocation(List<String> request, String key) {

        List<LatLng> locList = new  ArrayList<>();
        try {
            for(int i = 0; i < request.size(); i++) {
                GeoApiContext context = new GeoApiContext.Builder()
                        .apiKey(key)
                        .build();
                GeocodingResult[] results = GeocodingApi.geocode(context,
                        request.get(i)).await();


                locList.add(results[0].geometry.location);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ApiException ex){
            ex.printStackTrace();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        GeocodeConsumerResponse geocodeConsumerResponse = new GeocodeConsumerResponse(request,locList);

        return geocodeConsumerResponse;
    }
}

