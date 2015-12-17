Build with "mvn clean install"

asadmin start-database
asadmin start-domain
asadmin deploy --force=true --type war <path-to-RedeploymentTest.war>

Open file "ExampleExecutor"
Uncomment the following line, which will produce an error
//timerService.createIntervalTimer(-1000, -1000, new TimerConfig());

Build again "mvn clean install"

asadmin deploy --force=true --type war <path-to-RedeploymentTest.war>
Error should appear in the log:
Caused by: java.lang.IllegalStateException: EJBTimerService.createTimer can only be called from a timed object.  This EJB does not implement javax.ejb.TimedObject

Comment the line again, to remove the error
Build again "mvn clean install"

asadmin deploy --force=true --type war <path-to-RedeploymentTest.war>

Now it is not possible to deploy, because of the following error: 
Caused by: java.lang.IllegalStateException: Attempting to execute an operation on a closed EntityManagerFactory.

only restart of the domain resets this error
