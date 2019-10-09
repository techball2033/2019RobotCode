package robot.subsystems;


import edu.wpi.first.wpilibj.Spark;

public class Wheels{
    private Spark wheels;

    public Wheels() {
        wheels = new Spark(0);
    }

    public void runWheels(double speed)
    {
        wheels.set(speed);
    }

    public void stopWheels()
    {
        wheels.set(0);
    }

}