package game;

public class Doctor extends Townsfolk{
    public Doctor(String name, int id){
        super(name, id);
    }

    boolean Save(int player_id){
        boolean valid = false;
        //TODO: validate player_id
        return valid;
    }

    @Override
    public boolean Act(int player_id){
        return Save(player_id);
    }
}