package br.com.geocoding.geocodeconsumer.geocodeconsumerService;

import br.com.geocoding.geocodeconsumer.calculations.GeocodeConsumerCalculations;
import br.com.geocoding.geocodeconsumer.dtos.GeocodeConsumerDto;
import br.com.geocoding.geocodeconsumer.dtos.GeocodeConsumerResponseDto;
import br.com.geocoding.geocodeconsumer.exceptions.GeocodeConsumerExceptionHandler;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

@Service
public class GeocodeConsumerService {

    public GeocodeConsumerResponseDto obterGeolocation(GeocodeConsumerDto request, String key) {

        GeocodeConsumerCalculations calculations = new GeocodeConsumerCalculations();

        List<LatLng> locList = new  ArrayList<>();
        try {
           for(int i = 0; i < request.getAddress().size(); i++) {
               GeoApiContext context = new GeoApiContext.Builder()
                        .apiKey(key)
                        .build();
               GeocodingResult[] results = GeocodingApi.geocode(context,
                        request.getAddress().get(i)).await();

                locList.add(results[0].geometry.location);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }catch (ApiException ex){
           ex.getLocalizedMessage();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException ex){
            ex.getMessage();
        }

        String result = calculations.getEuclideanCalculation(locList);//Calculo Euclideano
        GeocodeConsumerResponseDto response = new GeocodeConsumerResponseDto(request,locList,result);

        return response;
    }
}

