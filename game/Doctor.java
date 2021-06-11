package game;

public class Doctor extends Townsfolk{
    public Doctor(String name, int id){
        super(name, id);
    }

    public boolean Save(int player_id){
        boolean valid = false;

        return valid;
    }

    public boolean Act(int player_id){
        return Save(player_id);
    }
}