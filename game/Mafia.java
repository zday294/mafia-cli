package game;
public class Mafia extends Player{
    
    public Mafia(String name, int id){
        super(name, id);
    }

    public boolean Kill(int player_id){
        boolean valid = false;

        //determine if player_id is valid

        return valid;
    }

    public boolean Act(int player_id){
        return Kill(player_id);
    }
    
}