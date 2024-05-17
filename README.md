Write a server by using SpringBoot Java and integrate Weather API from Rapid API. 
On the basis of that integration, expose your RESTful APIs as follows with JSON response.

Authentication Method: Header-based authentication with random client id and random
client secret.

API 1: Get the Weather forecast summary of Any city using API
(RapidApiGetForecastSummaryByLocationName)

API 2: Get hourly Weather forecast details of Any city using API
(RapidApiGetHourlyForecastByLocationName)

API Document: https://rapidapi.com/wettercom-wettercom-default/api/forecast9
(RapidApiGetForecastSummaryByLocationName &
RapidApiGetHourlyForecastByLocationName)


 ----- For both the api, i have managed to implemeit with single endpoint. 

 Curl for RapidApiGetForecastSummaryByLocationName : 

 curl --location 'http://localhost:8081/forecast/Berlin/summary/' \
--header 'X-RapidAPI-Key: 802fc4bed7mshe0a21adde9896efp195faejsn4924c071b798' \
--header 'X-RapidAPI-Host: forecast9.p.rapidapi.com'

Curl for RapidApiGetHourlyForecastByLocationName

curl --location 'http://localhost:8081/forecast/Berlin/hourly/' \
--header 'X-RapidAPI-Key: 802fc4bed7mshe0a21adde9896efp195faejsn4924c071b798' \
--header 'X-RapidAPI-Host: forecast9.p.rapidapi.com'
