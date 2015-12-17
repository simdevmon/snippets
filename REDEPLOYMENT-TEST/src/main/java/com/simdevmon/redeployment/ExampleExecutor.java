package com.simdevmon.redeployment;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;

/**
 * @author simdevmon
 */
@Startup
@Singleton
public class ExampleExecutor
{

    @Resource
    TimerService timerService;

    @Inject
    ExampleService service;

    @PostConstruct
    private void init()
    {
        //timerService.createIntervalTimer(-1000, -1000, new TimerConfig());
        System.out.println("#### Init");
        List<ExampleEntity> examples = service.getExamples();
        System.out.println("#### Examples: " + examples.size());
    }
}
