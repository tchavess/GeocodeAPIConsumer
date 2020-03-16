package br.com.geocoding.geocodeconsumer.geocodeconsumerResource;

import br.com.geocoding.geocodeconsumer.Config.GeocodeConsumerConfig;
import br.com.geocoding.geocodeconsumer.Beans.GeocodeConsumerResponse;
import br.com.geocoding.geocodeconsumer.geocodeconsumerService.GeocodeConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/geocoding-api")
public class GeocodeConsumerResource {
    public static final Logger logger = LoggerFactory.getLogger(GeocodeConsumerResource.class);
    @Autowired
    GeocodeConsumerService geocodeConsumerService;

    @PostMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeocodeConsumerResponse> resourceSearch(@RequestParam List<String> address){
        GeocodeConsumerResponse response = null;
        Date dateInit = new Date();
        GeocodeConsumerConfig geocodeConsumerConfig = new GeocodeConsumerConfig();
        try{
                       //chamada do serviço                               //Chave key_code Google
            response = geocodeConsumerService.obterGeolocation(address, geocodeConsumerConfig.getKey_code());

        }catch (Exception ex){
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
