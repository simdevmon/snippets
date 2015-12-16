package com.simdevmon.tcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 * @author simdevmon
 */
@Singleton
@Startup
public class ConnectionManager
{

    @Resource
    private ManagedExecutorService mes;

    @Inject
    private Instance<ConnectionListener> sockets;

    @PostConstruct
    public void init()
    {
        startSocket(5556);
        startSocket(5557);
    }

    private void startSocket(int port)
    {
        ConnectionListener listener = sockets.get();
        listener.setPort(port);
        mes.submit(listener);
    }

    @PreDestroy
    public void stop()
    {
        for (ConnectionListener socket : sockets)
        {
            try
            {
                socket.stop();
            }
            catch (IOException ex)
            {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
}
