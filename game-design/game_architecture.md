
# Game Architecture

## Model

### Classes

#### Player

##### Properties

Alive - boolean value representing whether a player is alive or dead
ID - integer value representing a player's id number
Name - string value representing a player's name

##### Methods

bool Accuse(int player_id) - accuse the player represented by player_id. Returns true if player_id is a valid player
void Vote(bool should_execute) - vote whether to execute the player currently on trial

#### Mafia: Player

##### Methods

bool Kill(int player_id) - vote on which player should be killed. returns true if player_id is a valid player

#### Townsfolk: Player

No additional properties or methods

#### Doctor: Townsfolk

##### Methods

bool Save(int player_id) - choose a player to save. returns true if player_id is a valid player

#### Sherrif: Townsfolk

#### Methods

int Investigate(int player_id) - choose a player to investigate. Returns 1 if mafia, 0 if townsfolk, and -1 if invalid player

#### Game

##### Properties

Vector<Player> Players - vector of players representing all the players in the game 
