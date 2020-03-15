package br.com.geocoding.geocodeconsumer.geocodeconsumerResource;

import Config.GeocodeConsumerConfig;
import br.com.geocoding.geocodeconsumer.LocationRequest;
import br.com.geocoding.geocodeconsumer.geocodeconsumerService.GeocodeConsumerService;
import com.google.maps.GeolocationApiRequest;
import com.google.maps.model.LatLng;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/geocoding-api")
public class GeocodeConsumerResource {
    public static final Logger logger = LoggerFactory.getLogger(GeocodeConsumerResource.class);
    @Autowired
    GeocodeConsumerService geocodeConsumerService;

    @PostMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LatLng>> resourceSearch(@RequestParam List<String> address){
        logger.info("ADDRESS: " + address.toString());
        List<LatLng> response = new ArrayList<>();
        Date dateInit = new Date();
        GeocodeConsumerConfig geocodeConsumerConfig = new GeocodeConsumerConfig();
        try{


            response = geocodeConsumerService.obterGeolocation(address, geocodeConsumerConfig.getKey_code());


        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            logger.info("####### GEOLOCATION RESOURCES RESUME ##########");
            logger.info("INIT: " + dateInit.toString());
            logger.info("REQUEST: " + address.toString());
            logger.info("RESPONSE: " + response.toString());
            logger.info("END: " + new Date());
            logger.info("####### END GEOLOCATION RESOURCES RESUME ##########");
        }

        return ResponseEntity.ok(response) ;
    }

}
