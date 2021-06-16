package server;

import game.*;
import java.util.Scanner;



public class MafiaServer {

    public static void main(String[] args) {
        int port = 8086;
        Game ServerGame;
        Scanner scan;
        Listener ServerListener;

        if (args.length > 1){
            port = Integer.parseInt(args[0]);
        }

        System.out.println("Welcome to the Mafia CLI Server. Let's get a game going.");
        scan = new Scanner(System.in);
        System.out.print("Enter a game name: ");
        String gamename = scan.nextLine();

        System.out.print(String.format("Set %s's password: ", gamename));
        String pass = scan.nextLine();

        ServerGame = new Game(gamename, pass);

        System.out.println("Game successfully created. Waiting for players....");

        ServerListener = new Listener(port);
        
        scan.close();
        while(true){
            Host h = ServerListener.Listen();
            h.ServerGame = ServerGame;
            h.start();
        }
    }
}
