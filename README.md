# AirManagement
# Launching API
to launch API use comand docker-compose up --build -d in comand line
use port localhost:8080

# Test Application

# Aircompany operations

Use port localhost:8080/air. 

Use get method to find all aircompanies.


**Use this body to put new aircompanie to db**

{

"airCompanyName": "AirCompanySecond", 

"companyType": 1, 

"foundedAt": "2017-05-08" 

} 

use port localhost:8080/air{id} to change(Put) or delete(Delete) requests aircompany by id;

# Airplane operations

Use port localhost:8080/airplane. Use get method to find all airplanes.



use this body to put new airplane to db, can be assign to a company immediately or moved later


{

    "airplaneName": "Delta1",
    
    "serialNumber": 2,
    
    "airCompanyId": {"id": 1},
    
    "numberOfFlight": 6,
    
    "flightDistance": 2000,
    
    "fuelCapacity": 1000,
    
    "type": "some type",
    
    "createdAt": "2018-01-05"
    
}

use port localhost:8080/airplane{id} to move(Put) airplane by id to anouther company 

Although set company id in which you want to move airplane for example: {"airCompanyId": {"id": 1}}

#Flights operations

Use port localhost:8080/flight. Use get method to find all flights.

Use this body to add new flight to db

{        

        "flightStatus": 2,
        
        "airCompanyId": {"id": 1},
        
        "airplaneId": {"id":2},
        
        "departureCountry": "Holand",
        
        "destinationCountry": "Ukraine",
        
        "distance": 3000,
        
        "estimatedFlightTime": 3,
        
        "delayStartAt": "2020-03-11 10:12:15",
        
        "startAt": "2020-02-01 10:12:15",
        
        "endAt": "2021-01-19 01:01:50",
        
        "flightCreatedDate": "2019-03-10"
        
}

Use port localhost:8080/flight/{id} to change flight status to (PENDING(0), DELAYED(1), ACTIVE(2), COMPLETED(3);)

Although set company id in which you want to change flight status for example: {"airCompanyId": {"id": 1}}

Use Get localhost:8080/flight/status to find all Flights in ACTIVE status and started more than 24 hours ago.

#End
