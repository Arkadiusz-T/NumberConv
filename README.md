# NumberConv
To run service clone this repository, enter rest-service-number-converter folder and run ./mvnw package comand to create jar file.
Then run: java -jar nameoftheCreatedJar to run service
Service will run on localhost:8080
There are 2 end-points:
/greeting
/NumberConversion

/NumberConversion takes 2 arguments: mode and numToConvert 
default values for mode="toHex" nad numToConvert=16

Argument    |   Description
--------------------------------------------------------------------
mode=toHex  |   in this mode take number(numToConvert) 
            |   and try to convert to hex format
----------------------------------------------------------------------
mode=toRoman|   in this mode take number(numToConvert) 
            |   and try to convert to roman format
------------------------------------------------------------------------
numToConvert|   string representing positive int
