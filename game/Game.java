package game;

import java.util.ArrayList;
import java.util.Hashtable;



public class Game{
    
    enum phase{
        UNSTARTED,
        DAY,
        NIGHT,
        FINISHED
    }

    String Name;
    String Password;
    //boolean Open;
    ArrayList<Player> Players;
    phase CurrentPhase;
    Hashtable<Integer, Integer> Accusations;



    public Game(String name, String password){
        Name = name;
        Password = password;
        Players = new ArrayList<Player>();
        CurrentPhase = phase.UNSTARTED;
        Accusations = new Hashtable<Integer, Integer>();
    }

    public int AddPlayer(Player p){
        Players.add(p);
        //Accusations.replace(key, oldValue, newValue)
        return Players.size();
    }

    public int GetNumPlayers(){
        return Players.size();
    }

    public void StartGame(){
        CurrentPhase = phase.DAY;

        //possibly other stuff? close the game?
    }

    public void AddAccusation(int accuser_id, int victim_id){
        Accusations.put(accuser_id, victim_id);
    }

    public String getName(){
        return Name;
    }

    public boolean checkPassword(String pass){
        return pass == Password;
    }
    
}