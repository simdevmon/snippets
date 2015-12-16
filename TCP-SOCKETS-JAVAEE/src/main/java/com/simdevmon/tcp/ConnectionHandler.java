package com.simdevmon.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simdevmon
 */
public class ConnectionHandler implements Runnable
{

    private Socket clientSocket;

    public Socket getClientSocket()
    {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run()
    {
        System.out.println("##### Accepting client: " + clientSocket.getPort());
        try
        {
            LocalDateTime now = LocalDateTime.now();
            Thread.sleep(5000);
            try (InputStream input = clientSocket.getInputStream(); OutputStream output = clientSocket.getOutputStream())
            {
                output.write(("HTTP/1.1 200 OK\n\nCurrentTime: " + now).getBytes());
            }
            System.out.println("##### Request processed: " + now);
        }
        catch (Exception ex)
        {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
