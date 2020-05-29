package br.com.geocoding.geocodeconsumer.geocodeconsumerResource;

import br.com.geocoding.geocodeconsumer.dtos.GeocodeConsumerDto;
import br.com.geocoding.geocodeconsumer.dtos.GeocodeConsumerResponse;
import br.com.geocoding.geocodeconsumer.dtos.GeocodeConsumerResponseDto;
import br.com.geocoding.geocodeconsumer.config.GeocodeConsumerConfig;
import br.com.geocoding.geocodeconsumer.geocodeconsumerService.GeocodeConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@Validated
@RestController
@RequestMapping("/geocoding-api")
public class GeocodeConsumerResource {

    public static final Logger logger = LoggerFactory.getLogger(GeocodeConsumerResource.class);
    @Autowired
    GeocodeConsumerService geocodeConsumerService;

    @PostMapping(value = "/location", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeocodeConsumerResponse<GeocodeConsumerResponseDto>> resourceSearch(
            @RequestBody @Valid GeocodeConsumerDto address)
        {

        GeocodeConsumerResponseDto response = new GeocodeConsumerResponseDto();
        Date dateInit = new Date();
        GeocodeConsumerConfig geocodeConsumerConfig = new GeocodeConsumerConfig();
        GeocodeConsumerResponse<GeocodeConsumerResponseDto> responseDto = new GeocodeConsumerResponse<>();

        try {
            //chamada do serviço                                        //key_code Google
            response = geocodeConsumerService.obterGeolocation(address, geocodeConsumerConfig.getKey_code());

        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            logger.info("####### GEOLOCATION RESOURCES RESUME ##########");
            logger.info("INIT: " + dateInit.toString());
            logger.info("REQUEST: " + address.toString());
            logger.info("RESPONSE: " + response.toString());
            logger.info("END: " + new Date());
            logger.info("####### END GEOLOCATION RESOURCES RESUME ##########");
        }
        responseDto.setContent(response);
        return ResponseEntity.ok(responseDto) ;
    }

}
