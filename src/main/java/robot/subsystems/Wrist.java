package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;

public class Wrist {

    private final int potRange = 0;//Range of pot in degrees
    private final int potOffset = 0;//Offset of pot from level

    private final double p = 0;
    private final double i = 0;
    private final double d = 0;

    private Spark wrist;

    private AnalogPotentiometer wristPot;
    
    private PIDController wristPID;

    public Wrist() {
        wrist = new Spark(1);
        wrist.setInverted(false);

        wristPot = new AnalogPotentiometer(7, potRange, potOffset);

        wristPID = new PIDController(p, i, d, wristPot, wrist);
    }

    public void setPosition(double pos) {
        wristPID.setSetpoint(pos);
    }

    public void override(double speed) {
        wrist.set(speed);
    }

    public void stopArm() {
        wrist.set(0);
    }

    public void reset() {
        wristPID.reset();
    }
}