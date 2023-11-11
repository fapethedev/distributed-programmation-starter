package com.fapethedev.pd.codetwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Socket clientSocket;
    private int num;

    private int serverSecretNumber;

    public ServerThread(Socket clientSocket, int num, int serverSecretNumber) {
        this.clientSocket = clientSocket;
        this.num = num;
        this.serverSecretNumber = serverSecretNumber;
    }

    @Override
    public void run()
    {
        super.run();
        try(
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
            ){

            System.out.println("Client " + clientSocket.getLocalAddress() +  " n° " + num + " connecté");
            writer.println("Veuillez devinez le nombre secret [1 , 100] : \n");

            String s;

            while ((s = reader.readLine()) != null)
            {
                int number = Integer.parseInt(s);

                System.out.println("Client " + clientSocket.getLocalAddress() +  " n° " + num +  " a ecrit : " + number);

                if (number < serverSecretNumber)
                {
                    writer.println("Vous y etes presque entre un nombre plus grand");
                }
                else if (number > serverSecretNumber)
                {
                    writer.println("Vous y etes presque entre un nombre plus petit");
                }
                else
                {
                    writer.println("Vous avez trouvez le nombre secret");
                    System.out.println("Client " + clientSocket.getLocalAddress() + " n° " + num + " a trouver le nombre secret : " + serverSecretNumber);
                    System.out.println();

                    writer.println("Le nombre secret a été trouver le jeu est terminer");
                    break;
                }
            }
            System.out.println("Fermeture de la connexion.");
            System.exit(0);
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage() + ", cause: " + e.getCause() + ", " + e.getClass().getSimpleName());
        }
    }
}
