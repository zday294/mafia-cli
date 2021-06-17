// This class allows mafia-cli to be run as a single program 
// Hopefully this will make packaging as one program easier later


import client.*;
import server.*;

public class mafia {

    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Usage: mafia <execution path> <additional parameters>");
            System.exit(1);
        }

        switch (args[0]) {
            case "player":
            if (args.length < 2){
                System.out.println("Usage for players: mafia player <ip address> <optional port>");
                break;
            }
            else if (args.length == 3){
                MafiaClient.main(new String[] {args[1], args[2]});
            }
            else{
                MafiaClient.main(new String[]{args[1], "8086"});
            }
            
            
            break;
            case "server":
            if (args.length < 2){
                MafiaServer.main(new String[] {});
            }
            else{
                MafiaServer.main(new String[] {args[1]});
            }
            break;
            default:
            break;
        }
    }
}
