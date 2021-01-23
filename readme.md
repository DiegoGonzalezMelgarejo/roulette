# Roulette


* docker-compose up -d


## End points

* GET
  * List roulettes ->  http://localhost:8080/api/ 
* POST
  * Create Roulettes -> http://localhost:8080/api/ 
  * Open Roulettes ->http://localhost:8080/api/open/{idRoulette}
  * Create Bet -> http://localhost:8080/api/bet/{idRoulette} 
      * Body example {
    "id":"hola",
    "number": -1,
    "color":"rojo",
    "cash":2500
} bet only color the number is -1, bet only number color empty
       * Header -> userId 
 * Close bet -> http://localhost:8080/api/close/{idRoulette}