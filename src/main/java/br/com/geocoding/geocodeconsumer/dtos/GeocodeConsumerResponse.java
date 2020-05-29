package br.com.geocoding.geocodeconsumer.dtos;

import java.util.ArrayList;
import java.util.List;

public class GeocodeConsumerResponse<T> {

  private T content;
  private List<String> errors;

  public GeocodeConsumerResponse() {
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public List<String> getErrors() {
    if(this.errors == null){
      this.errors = new ArrayList<>();
    }
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

  @Override
  public String toString() {
    return "GeocodeConsumerResponse{" +
            "content=" + content +
            ", errors=" + errors +
            '}';
  }
}
