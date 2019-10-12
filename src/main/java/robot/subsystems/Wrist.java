package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;

public class Wrist {

    private final int potRange = ;//Range of pot in degrees
    private final int potOffset = ;//Offset of pot from level

    private Spark wrist;

    private AnalogPotentiometer armPot;

    public Wrist() {
        wrist = new Spark(1);
        wrist.setInverted(false);

        armPot = new AnalogPotentiometer(7, potRange, potOffset);
    }

    public void override(double speed) {
        wrist.set(speed);
    }

    public void stopArm() {
        wrist.set(0);
    }
}