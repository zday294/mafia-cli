package game;

public class Townsfolk extends Player{
    public Townsfolk(String name, int id){
        super(name, id);
    }

    public boolean Act(int player_id){
        return true;
    }
}