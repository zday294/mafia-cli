package server;

import game.*;
import java.util.Scanner;



public class MafiaServer {
    
    
    
    public static void main(String[] args) {
        Game ServerGame;
        Scanner scan;
        Listener ServerListener;
        System.out.println("Welcome to the Mafia CLI Server. Let's get a game going.");
        scan = new Scanner(System.in);
        System.out.print("Enter a game name: ");
        String gamename = scan.nextLine();

        System.out.print(String.format("Set %s's password: ", gamename));
        String pass = scan.nextLine();

        ServerGame = new Game(gamename, pass);

        System.out.println("Game successfully created. Waiting for players....");

        ServerListener = new Listener(8086);
        
        scan.close();
        while(true){
            Host h = ServerListener.Listen();
            h.ServerGame = ServerGame;
            h.start();
        }

    }
}
