package br.com.geocoding.geocodeconsumer.Calculations;

import com.google.maps.model.LatLng;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GeocodeConsumerCalculations {

    public String getEuclideanCalculation(List<LatLng> chord){

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        double soma = 0;
        try {
            List<LatLng> coords = new ArrayList<>(chord);
            for(LatLng coorD: coords){
                soma += Math.pow((coorD.lat - coorD.lng), 2);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        double result = Math.sqrt(soma);
        return df.format(result);
    }
}
