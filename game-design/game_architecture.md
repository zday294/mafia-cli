
# Game Architecture

## Model

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
Name | string | String representing the name of this game
Open | bool | Is the game public
Players | Vector<<n>Player> | Vector of players representing all the players in the game
Phase | int | Current phase of the game. 0 = day, 1 = night
Accusations | Vector<<e>Pair<<n>int, int> | Keep track of who has accused who
NumAccusations | Vector<<n>int> | 
Votes | int | Number of votes submitted in most recent trial

Methods
Name | Return Type | Parameters | Description
---|---|---|---
AddPlayer | int | Player p | Add a player to the game
StartGame | int | none | Begin the game
ToString | string | none | Serialize the game state
AddAccusation | int | int accuser_id, int victim_id | Add an accusation from the accuser to the victim


## View

### Printer




## Network

### Client

This part needs research. I dont know how c++ does networking, but I have some idea of what I need.

Properties
Name | Type | Description
---|---|---
MyPlayer | Player | contains player information
CurrentGame | Game | contains game state information

Methods
Name | Return Type | Parameters | Description
---|---|---|---
ConnectToServer | int | string ip_address, int port | Connect to a server. Retruns 0 on success, non-zero on error 
ConnectToGame | int | string gameName | Connect to a game on the server. Retruns 0 on success, non-zero on error
GetGameState | int | Game* game | Get the game state from the server. Returns 0 on success, non-zero on error
SendCommand | int | string command | Send a command to the server. Returns 0 on success, non-zero on error
HandleCommand | int | none | Recieve command from the server and handle it. Returns 0 on success, non-zero on error

### Server

Properties
Name | Type | Description
---|---|---
GameList | Vector<<n>Game> | List of games on the server
Clients | Vector<<n>?> | List of all the clients currently connected



Methods
Name | Return Type | Parameters | Description
---|---|---|---
Accept | int | ? | Accept incoming connections and move them to the handler
HandleClient | int | ? | Take care of a client while it is connected
