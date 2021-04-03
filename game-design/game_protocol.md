# Game protocol

## Connection

Once a client connects to the server, the server will send the following lines to the client

```
name server <server_name>
message "What is your name?"
request name
```

Where server_name is the name of the server sending the message

The client should respond with the following

```
name client <client_name>
```

where client_name is a name entered by the user to be presented to the other players.

The server then sends

```
id <client_name> <id_num>
```

where client_name is the name the client sent to the server and id_num is a client id provided by the server. The client will then use this id_num to identify itself to the server in future interactions.

## Before the game starts

Before the game starts, players are held in a lobby. After a client connects, the server sends

```
message "Players in lobby"
message "<player_name>"
```

with one message with a player_name per player in the lobby (including the current player). 

All players presently in the lobby also recieve a message when a player has joined.

```
message "Player <player_name> has joined the game"
```

## Starting the game

Clients send the following message to the server to indicate they are ready to begin

```
ready <id_num>
```

When the server has all clients registered as ready, it sends the following

```
message "Game starting"
game begin
role <role_id> <role_name>
```

where role_name is the name of the player's role and role_id is an integer identifier of the players role

## Playing the game

Clients can send a message to the server with the following command

```
message "<message_string>"
```

where message_string is a string of characters (maximum 140).

When the server needs to set a time limit on an activity, the sever will sent the following command to the clients

```
time <seconds>
```

where seconds is the time in seconds to set the timer for.

When the game calls for an action, the server will send a message of the following format

```
request action <action_id>
```

Most player actions will be sent by the client using the following format

```
action <action_id> <role_id> <client_id> <player_id>
```

The actions available to players depend on the role. 

The server will give a response in the following format

```
response <action> <validation>
```

where action is the action the client took and validation is whether the action command was valid.

If the server does not recieve an action from the client, the server will check for a client connection with the following string

```
check <client_id>
```

The client should respond with

```
here <server_name>
```

If the server does not get a response, the server will close the client connection.

## Ending the game

When the game is over, the server will send the following to the client

```
game end
winner <team>
disconnect
```

## Disconnecting early

If a client wishes to disconnect early, it must send the following command.

```
disconnect
```

Following this, the server will let all other clients know that the client has disconnected with the following line

```
message "Player <player_name> has disconnected"
```
