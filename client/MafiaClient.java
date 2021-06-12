package client;

import java.io.*;
import java.net.Socket;


public class MafiaClient {
    public static void main(String[] args){
        if (args.length < 2){
            System.out.println("Usage: MafiaClient <ip> <port>");
            return;
        }
        String ip = args[0];
        int port = Integer.parseInt(args[1]);
        
        try{
            Socket socket = new Socket(ip, port);
            InputStream in = socket.getInputStream();
            // OutputStream out = socket.getOutputStream();

            Thread t = new Thread(new Runnable() {
                @Override
                public void run(){
                String messageFromServer = "";
                while(messageFromServer != "end"){
                        try{
                            messageFromServer = in.readAllBytes().toString();
                            System.out.println(messageFromServer);
                        }
                        catch(IOException m){
                            System.err.println(m.getMessage());
                        }
                    }
                }
                //here i need to handle when the message from the server is end
            });
            t.start();


            socket.close();
        }
        catch (IOException e){
            System.out.println("An error has occured while trying to connect to the server");
            System.err.println(e.getMessage());

        }
    }   
}
