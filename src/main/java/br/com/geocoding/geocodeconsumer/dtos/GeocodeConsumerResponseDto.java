package br.com.geocoding.geocodeconsumer.dtos;

import br.com.geocoding.geocodeconsumer.calculations.GeocodeConsumerCalculations;
import com.google.maps.model.LatLng;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class GeocodeConsumerResponseDto {

  private GeocodeConsumerDto address;  //Lista com os endereços pesquisados
  private List<LatLng> coords;  //coordenadas dos endereçoes pesquisados
  private String result;   //Variavel que armazena o resultado do calculo euclideano entre as coordenadas

  public GeocodeConsumerResponseDto(){
  }

  public GeocodeConsumerResponseDto(GeocodeConsumerDto address, List<LatLng> coords,String result){
    this.address = address;
    this.coords = coords;
    this.result = result;
  }
}
