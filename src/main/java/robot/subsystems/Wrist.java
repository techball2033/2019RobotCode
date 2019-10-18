package robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Spark;

public class Wrist {

    private final int potRange = 2000;//Range of pot in degrees
    private final int potOffset = -1000;//Offset of pot from level

    private final double p = 3;
    private final double i = 0.006;
    private final double d = 0;

    private Spark wrist;

    private AnalogPotentiometer wristPot;
    
    private PIDController wristPID;

    public Wrist() {
        wrist = new Spark(5);
        wrist.setInverted(false);

        wristPot = new AnalogPotentiometer(1, potRange, potOffset);

        wristPID = new PIDController(p, i, d, wristPot, wrist);
        wristPID.setOutputRange(-1, 1);
    }

    public void setPosition(double pos) {
        wristPID.enable();
        wristPID.setSetpoint(pos);
    }

    public void override(double speed) {
        wristPID.disable();
        wrist.set(speed);
    }

    public void stopArm() {
        override(0);
    }

    public void reset() {
        wristPID.reset();
    }
}