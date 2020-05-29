# GeocodeAPIConsumer
API REST que consome Geocoding API do Google atraves da biblioteca GeoApiContext para calculo Euclidiano entre coordenadas

URL para testes: http://localhost:8080/geocoding-api/location/?address=Av. Rio Branco, 1 - Centro, Rio de Janeiro - RJ,
20090003&address=Praça Mal. Âncora, 122 - Centro, Rio de Janeiro - RJ, 20021200&address=Rua 19 de
Fevereiro, 34 - Botafogo, Rio de Janeiro -RJ, 22280030

{
    "address": [
        "Av. Rio Branco, 1 - Centro, Rio de Janeiro - RJ,20090003",
        "Praça Mal. Âncora, 122 - Centro, Rio de Janeiro - RJ, 20021200",
        "Rua 19 de Fevereiro, 34 - Botafogo, Rio de Janeiro - RJ, 22280030"
    ],
    "coords": [
        {
            "lat": -22.8973551,
            "lng": -43.1802782
        },
        {
            "lat": -22.9039608,
            "lng": -43.1703536
        },
        {
            "lat": -22.9507173,
            "lng": -43.1876474
        }
    ],
    "result": "35,09"
}

Onde "address" sao os endereços pesquisados, "coords" os coordenadas dos endereços pesquisados, obtidos 
atraves do geocoding-api e result é o resultado obtido atraves do calculo de distancia euclideana entre os pontos

