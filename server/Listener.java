package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener{
    int Port;
    ServerSocket ClientAccepter;

    public Listener(int port){
        Port = port;
        try{
            ClientAccepter = new ServerSocket(Port);
        }
        catch(IOException e){

        }
        catch(IllegalArgumentException f){
            System.err.printf("Error creating socket. Invalid port: %d\n", Port);
            System.out.printf("Invalid port number. Current port %d\n", Port);
        }
    }

    public Host Listen(){
        Host h;
        Socket s;
        try{
            s = ClientAccepter.accept();
            h = new Host(s);
            return h;
        }
        catch (IOException e){
            System.err.println(String.format("Error accepting a client\n%s", e.getMessage()));
            System.out.print("The server could not establish a connection with the client. Please restart");
        }

        return null;
    }
}