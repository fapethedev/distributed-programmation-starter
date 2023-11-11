package com.fapethedev.pd.codetwo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Integer secret = new Random().nextInt(1, 101);
        System.out.println("Serveur démarré");
//        System.out.println("Devinette du nombre secret " + Integer.toOctalString(secret));

        try(ServerSocket serverSocket = new ServerSocket(6668))
        {
            int i = 1;
            while (true)
            {
                Socket client = serverSocket.accept();
                ServerThread serverThread = new ServerThread(client, i++, secret);

                serverThread.start();
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage() + ", cause: " + e.getCause());
        }
    }
}
