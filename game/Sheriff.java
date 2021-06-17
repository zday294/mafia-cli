package game;

public class Sheriff extends Townsfolk{

    public Sheriff(String name, int id){
        super(name, id);
    }

    boolean Investigate(int player_id){

        //TODO: validate player_id
        

        return false;
    }


    @Override
    public boolean Act(int player_id){

        return Investigate(player_id);
    }   
    
}
