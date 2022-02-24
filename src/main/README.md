
# Shop Quabbly

Shop Quabbly is a  RESTful Stock API that provides the
 following services






# Shop Quabbly

Shop Quabbly is a  RESTful Stock API that provides the
 following services





##Features

GET /api/v1/stocks ... (get the List of Stocks)

GET /api/v1/stocks/{id} ... 
(get a single Stock from the list by its ID)

PUT /api/v1/stocks/{id} ... 
(update the current_price/name of a single Stock)

DELETE /api/v1/stocks/{id} ... 
(delete a single Stock by its ID)

POST /api/v1/stocks ... 
(create a new Stock)

## Prerequisites
Java 11, Maven, PostMan, MySQL.

## To Build
mvn clean install

## Database
To set up the database, run the sql script 
in my resourse file:
./resources/db/setup-db.sql on MySQL

## To run on Java
jar ./target/quabblyStocks.jar


## Acknowledgements
github.com/iseoluwaYN/ShopQuabbly