package game;
public abstract class Player{
    public String Name; //A player's name. Set each round
    public int ID; // A player's id unique to the current round
    public boolean IsAlive;
    boolean Vote; //Maybe make this part of a vote class


    public Player(String name, int id){
        Name = name;
        ID = id;
        IsAlive = true;
        Vote = false;
    }

    public boolean Accuse(int player_id){
        boolean ret = false;
        
        //check if player_id is valid

        return ret;
    }

    public void Vote(boolean should_execute){
        //accuse player_id 
    }

    public abstract boolean Act(int player_id);

}