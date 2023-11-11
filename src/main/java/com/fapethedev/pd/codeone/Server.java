package com.fapethedev.pd.codeone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server
{
    ServerSocket serverSocket;

    {
        try
        {
            serverSocket = new ServerSocket(7777);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
