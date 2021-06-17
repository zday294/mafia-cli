package server;

import java.io.*;
import java.net.Socket;
import game.*;
import protocol.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//The host class will be a thread to handle a client
public class Host extends Thread{

    
    Socket Sock;
    PrintWriter Out;
    BufferedReader In;
    public Game ServerGame;
    // Timer WriteTimer;
    String MessageBuffer;
    ScheduledExecutorService WriteService;
    Player ClientPlayer;

    ProtocolMessage MostRecentMessage;

    
    public Host(Socket sock){
        MessageBuffer = "";
        Sock = sock;
        try{
            Out = new PrintWriter(Sock.getOutputStream(), true);
            In = new BufferedReader(new InputStreamReader(Sock.getInputStream()));
        }
        catch(IOException e){
            System.err.println(String.format("Error creating a Talker\n%s", e.getMessage()));
            System.out.print("The server could not establish a connection with the client. Please restart");
        }

        WriteService = Executors.newSingleThreadScheduledExecutor();
        WriteService.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run(){
                WriteToClient();
            }
        }, 2000, 200, TimeUnit.MILLISECONDS);

    }


    String HandleClient(String message){
        ProtocolMessage m;
        try{
            m = MessageBuilder.Build(message);
            if (m.getTypeName() == "retry"){
                m = MostRecentMessage;
            }
            else{
                MostRecentMessage = m;
            }

        }
        catch (InvalidProtocolMessageException ipme) {
            m = new PlainMessage("\"Bad protocol message\"");
        }
        return m.toString();
    }   


    public void run(){
        System.out.printf("Thread %d: connection accepted from %s\n", Thread.currentThread().getId(), Sock.getInetAddress());
        // String gamename = ServerGame.getName();
        MessageBuffer += String.format("Welcome to Mafia CLI. Your have connected to %s\r\n", ServerGame.getName());

        while(true){
            try{
                String clientMessage = In.readLine();
                MessageBuffer += HandleClient(clientMessage);
            }
            catch(IOException e){
                System.err.printf("Error reading message from client\n%s\n", e.getMessage());
            }
        }
    }


    public void WriteToClient(){
        Out.print(MessageBuffer);
        Out.flush();
        MessageBuffer = "";
    }


}

