package com.fapethedev.pd.codetwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread extends Thread
{
    Socket client;

    public ClientThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        super.run();
        try
            (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))
            ){

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
