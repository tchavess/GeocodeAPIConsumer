package br.com.geocoding.geocodeconsumer.Beans;

import br.com.geocoding.geocodeconsumer.Calculations.GeocodeConsumerCalculations;
import com.google.maps.model.LatLng;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class GeocodeConsumerResponse {

    private List<String> address;  //Lista com os endereços pesquisados
    private List<LatLng> coords;  //coordenadas dos endereçoes pesquisados
    private String result;   //Variavel que armazena o resultado do calculo euclideano entre as coordenadas


   public GeocodeConsumerResponse(List<String> address, List<LatLng> coords){
       GeocodeConsumerCalculations geocodeConsumerCalculations = new GeocodeConsumerCalculations();
       this.address =  address;
       this.coords = coords;
       //Metodo que faz o calculo Euclidiano entre os pontos
       this.result = geocodeConsumerCalculations.getEuclideanCalculation(this.coords);
    }
}
