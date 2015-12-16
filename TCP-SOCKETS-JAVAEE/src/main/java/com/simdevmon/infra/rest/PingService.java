package com.simdevmon.infra.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author simdevmon
 */
@Path("ping")
public class PingService
{

    @GET
    public String ping()
    {
        return "server is alive: " + System.currentTimeMillis();
    }

}
