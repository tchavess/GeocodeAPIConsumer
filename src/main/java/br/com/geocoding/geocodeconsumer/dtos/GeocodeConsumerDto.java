package br.com.geocoding.geocodeconsumer.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class GeocodeConsumerDto {

  @NotNull(message = "{address.not.null}")
  @NotEmpty(message = "{address.not.empty}")
  private List<String> address;

  public GeocodeConsumerDto() {
  }

  public List<String> getAddress() {
    if(this.address == null){
      this.address = new ArrayList<>();
    }
    return address;
  }

  public void setAddress(List<String> address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "GeocodeConsumerDto{" +
            "address=" + address +
            '}';
  }
}
