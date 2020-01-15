# Current Limiting

Tutorial on how to current limit NEO motors (Spark MAX controllers)

## On the robot

The first thing that you want to do is download the latest version of the [REV SPARK MAX Client](http://www.revrobotics.com/sparkmax-software/#spark-max-client-application)

Then connect to the SPARK MAX over USB-C
(https://github.com/CrimsonRobotics/currentLimiting/blob/104c33788f1967a49fc1e8067540a90fea0264a0/imgs/SPARK-MAX-USB-C.jpg)

Then open the REV SPARK MAX Client Software
It should auto-connect to the SPARK MAX but if it doesn't, select the ID of the controller and click connect
If you don't see any devices, click the refresh button
(https://github.com/CrimsonRobotics/currentLimiting/blob/104c33788f1967a49fc1e8067540a90fea0264a0/imgs/Client-Connect.png)

After you are connected, go to Smart Current Limiting and change the number to what electrical tells you.
This number is how many amps (A) the motor is allowed to use.
(https://github.com/CrimsonRobotics/currentLimiting/blob/104c33788f1967a49fc1e8067540a90fea0264a0/imgs/Current-Limit-1.png)

Click "Save configuration" and then click "Yes, update"
(https://github.com/CrimsonRobotics/currentLimiting/blob/104c33788f1967a49fc1e8067540a90fea0264a0/imgs/Saving.png)

Click "Disconnect" once you're done updating it

## In your code

You don't really have to do much here but you can log your current output to shuffleboard/smart dashboard

In your drivetrain code, you want to add the line,

```java
SmartDashboard.putNumber("<text here>", motor.getOutputCurrent());
```

You can see this in the Drivetrain subsystem

That's all, have fun programming!
