package br.com.geocoding.geocodeconsumer.geocodeconsumerResource;

import Config.GeocodeConsumerConfig;
import br.com.geocoding.geocodeconsumer.Location;
import br.com.geocoding.geocodeconsumer.geocodeconsumerService.GeocodeConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/geocoding-api")
public class GeocodeConsumerResource {
    public static final Logger logger = LoggerFactory.getLogger(GeocodeConsumerResource.class);
    @Autowired
    GeocodeConsumerService geocodeConsumerService;

    @GetMapping(value = "/location", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Location> resourceSearch(@RequestParam(value="address", required = false) String address){

        Location response = new Location();
        Date dateInit = new Date();
        GeocodeConsumerConfig geocodeConsumerConfig = new GeocodeConsumerConfig();
        try{


            response =  geocodeConsumerService.obterGeolocation(address, geocodeConsumerConfig.getKey_code());


        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            logger.info("####### GEOLOCATION RESOURCES RESUME ##########");
            logger.info("INIT: " + dateInit.toString());
            logger.info("Response: " + response.toString());
            logger.info("END: " + new Date());
            logger.info("####### END GEOLOCATION RESOURCES RESUME ##########");
        }

        return ResponseEntity.ok(response) ;
    }

}
