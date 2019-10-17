package robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Arm {

    private final int potRange = 0;//Range of pot in degrees
    private final int potOffset = 0;//Offset of pot from level

    private final double p = 0;
    private final double i = 0;
    private final double d = 0;

    private WPI_TalonSRX left;
    private WPI_TalonSRX right;

    private SpeedControllerGroup armGroup; 

    private AnalogPotentiometer armPot;

    private PIDController armPID;

    public Arm() {
        left = new WPI_TalonSRX(4);
        right = new WPI_TalonSRX(5);

        right.setInverted(true);//Inverting one motor as they drive in different directions. CHECK WHICH SIDE TO INVERT.

        armGroup = new SpeedControllerGroup(left, right);

        armPot = new AnalogPotentiometer(6, potRange, potOffset);

        armPID = new PIDController(p, i, d, armPot, armGroup);
    }

    public void setPosition(double pos) {
        armPID.setSetpoint(pos);
    }

    public void override(double speed) {
        armGroup.set(speed);
    }

    public void stopArm() {
        armGroup.set(0);
    }

    public void reset() {
        armPID.reset();
    }
}