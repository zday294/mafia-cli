
# Game Architecture

## Model

### Model Classes

### Player

Properties
Name | Type | Description
---|---|---
Alive | bool | Whether a player is alive or dead
ID | int | Player's id number
Role | int | A player's role. 0 for townsfolk, 1 for mafia, 2 for doctor, 3 for sherrif
Name | string | Player's name
HasVoted | bool | Player has voted in the most recent trial

Methods
Name | Return Type | Parameters | Description
---|---|---|---
Accuse | bool | int player_id | Accuse the player represented by player_id. Returns true if player_id is a valid player
Vote | void | bool should_execute | Vote whether to execute the player currently on trial

### Mafia: Player

Methods
Name | Return Type | Parameters | Description
---|---|---|---
Kill | bool | int player_id | Vote on which player should be killed. Returns true if player_id is a valid player

### Townsfolk: Player

No additional properties or methods

### Doctor: Townsfolk

Methods

Name | Return Type | Parameters | Description
---|---|---|---
Save | bool | int player_id | Choose a player to save. returns true if player_id is a valid player

### Sherrif: Townsfolk

Methods
Name | Return Type | Parameters | Description
---|---|---|---
Investigate| int | int player_id | Choose a player to investigate. Returns 1 if mafia, 0 if townsfolk, and -1 if invalid player

### Game

Properties
Name | Type | Description
---|---|---
Players | Vector<<n>Player> | Vector of players representing all the players in the game
Phase | int | Current phase of the game. 0 = day, 1 = night
Accusations | Vector<<e>int> | Current number of accusations on each player
Votes | int | Number of votes submitted in most recent trial

## View

### View Classes

### Client

This part needs research. I dont know how c++ does networking, but I have some idea of what I need.

Properties
Name | Type | Description
---|---|---
MyPlayer | Player | contains player information