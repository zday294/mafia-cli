package server;

import java.io.*;
import java.net.Socket;
import game.*;

//The host class will be a thread to handle a client
public class Host extends Thread{

    
    Socket Sock;
    PrintWriter Out;
    BufferedReader In;
    public Game ServerGame;
    
    public Host(Socket sock){
        Sock = sock;
        try{
            Out = new PrintWriter(Sock.getOutputStream(), true);
            In = new BufferedReader(new InputStreamReader(Sock.getInputStream()));
        }
        catch(IOException e){
            System.err.println(String.format("Error creating a Talker\n%s", e.getMessage()));
            System.out.print("The server could not establish a connection with the client. Please restart");
        }
    }


    public void run(){
        System.out.printf("Thread %d: connection accepted from %s\n", Thread.currentThread().getId(), Sock.getInetAddress());
        // String gamename = ServerGame.getName();
        Out.printf("Welcome to Mafia CLI. Your have connected to %s\n", ServerGame.getName() );
    }
}

