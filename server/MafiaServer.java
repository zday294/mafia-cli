package server;

import game.*;
import java.util.Scanner;


public class MafiaServer {
    static Game ServerGame;
    static Scanner scan;
    static Listener ServerListener;

    

    public static void main(String[] args) {

        System.out.println("Welcome to the Mafia CLI Server. Let's get a game going.");
        scan = new Scanner(System.in);
        System.out.print("Enter a game name: ");
        String gamename = scan.nextLine();

        System.out.print(String.format("Set %s's password: ", gamename));
        String pass = scan.nextLine();

        ServerGame = new Game(gamename, pass);

        System.out.println("Game successfully created. Waiting for players....");

        ServerListener = new Listener(8086);
        
        while(true){
            Host h = ServerListener.Listen();
            h.ServerGame = ServerGame;
            h.start();
        }

    }
}
