package client;

import java.io.*;
import java.net.Socket;

import protocol.*;

// import java.io.InputStreamReader;


public class MafiaClient {

    public static void HandleMessage(String message) throws InvalidProtocolMessageException{
        ProtocolMessage pm = MessageBuilder.Build(message);

        
    }

    public static void main(String[] args){
        if (args.length < 2){
            System.out.println("Usage: MafiaClient <ip> <port>");
            return;
        }
        String ip = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.println("Searching for game...");        
        try{
            Socket socket = new Socket(ip, port);
            System.out.printf("Successfully connected to server %s\n", ip);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // OutputStream out = socket.getOutputStream();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run(){
                String messageFromServer = "";
                while(messageFromServer != "game ended"){
                        try{
                            messageFromServer = in.readLine();
                            HandleMessage(messageFromServer);
                            // System.out.println(messageFromServer);
                        }
                        catch(IOException m){
                            System.err.println(m.getMessage());
                        }
                        catch(InvalidProtocolMessageException ipme){
                            System.err.println(ipme.getMessage());
                        }
                    }
                }
                //here i need to handle when the message from the server is end
            });
            t.start();


            t.join();
            socket.close();
        }
        catch (IOException e){
            System.out.println("An error has occured. Check the error logs for further details");
            System.err.println(e.getMessage());
            
        }
        catch(InterruptedException iException){
            System.err.println(iException.getMessage());
        }
    }   
}
