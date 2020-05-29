# GeocodeAPIConsumer
API REST que consome Geocoding API do Google atraves da biblioteca GeoApiContext para calculo Euclidiano entre coordenadas

URL para testes: http://localhost:8080/geocoding-api/location   //POST method

Body: {
	"address":[
		"Rua Figueiredo Rocha, 896 Vigario Geral",
		"Praça Francisco Manoel da Silva, 25 Vila Amelia"]
}

Response:

{
    "content": {
        "address": {
            "address": [
                "Rua Figueiredo Rocha, 896 Vigario Geral",
                "Praça Francisco Manoel da Silva, 25 Vila Amelia"
            ]
        },
        "coords": [
            {
                "lat": -22.8085239,
                "lng": -43.31751
            },
            {
                "lat": -22.7844615,
                "lng": -43.3211179
            }
        ],
        "result": "29,02"
    },
    "errors": []
}

Onde "address" sao os endereços pesquisados, "coords" as coordenadas dos endereços pesquisados, obtidos 
atraves do geocoding-api e result é o resultado obtido atraves do calculo de distancia euclideana entre os pontos


[![Build Status](https://travis-ci.org/tchavess/GeocodeAPIConsumer.svg?branch=master)](https://travis-ci.org/tchavess/GeocodeAPIConsumer)
