## Football manager app
Application that can help you to manage your football teams and players in them. It uses internal H2 database.
You are able to perform all basic CRUD operations with your individual players and teams, as well as perform transfer of a player from one team to another.
Transfer process is managing both payment and transfer of a player itself. You can't transfer player that is too expensive to a team that don't have enough money.

## Setup
- Clone project to your IDE
- You can perform /inject request that will populate database with initial players and teams (http://localhost:8080/inject).
- You also can use attached postman collection to communicate with initial data and update it (https://www.getpostman.com/collections/e57f617f06d2a27f8344)...
- ...or you can manage teams and players yourself with set of endpoints given below.

## Endpoints:
- POST http://localhost:8080/players - creates a new player
- POST http://localhost:8080/teams - creates a new team
- GET http://localhost:8080/players - gives you a list of all players (with pagiantion)
- GET http://localhost:8080/teams - gives you a list of all teams (with pagiantion)
- GET http://localhost:8080/players/{id} - gives you a player by his id 
- GET http://localhost:8080/teams/{id} - gives you a team by its id 
- DELETE http://localhost:8080/players/{id} - deletes player with given id
- DELETE http://localhost:8080/teams/{id} - deletes team with given id
- POST http://localhost:8080/players/{id} - updates player with given id
- POST http://localhost:8080/teams/{id} - updates team with given id
- POST http://localhost:8080/transfer?playerId={playerID}&teamFromId={teamFromId}}&teamToId={teamToId} - performs transfer of a player with {playerId} from {teamFromId} to {teamToId}.
You can test these endpoints using postman yourself or using prepared collection(here's the link again https://www.getpostman.com/collections/e57f617f06d2a27f8344 :)
