package com.simdevmon.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author simdevmon
 */
public class ConnectionListener implements Runnable
{

    @Resource
    private ManagedExecutorService mes;

    @Inject
    private Instance<ConnectionHandler> handles;

    private int port;

    private ServerSocket socketListener;

    @Override
    public void run()
    {
        try
        {
            System.out.println("### Start connection listener at: " + port);
            socketListener = new ServerSocket(port);
            while (true)
            {
                Socket connectionSocket = socketListener.accept();
                ConnectionHandler acceptor = handles.get();
                acceptor.setClientSocket(connectionSocket);
                mes.submit(acceptor);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(ConnectionListener.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public void stop() throws IOException
    {
        System.out.println("### Stop connection listener at: " + port);
        socketListener.close();
    }

    public int getPort()
    {
        return port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

}
