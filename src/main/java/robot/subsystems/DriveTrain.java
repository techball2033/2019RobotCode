package robot.subsystems;  

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class DriveTrain {

    private VictorSPX leftFront;
    private VictorSPX leftBack;
    private VictorSPX rightFront;
    private VictorSPX rightBack;

    public DriveTrain() {
        leftFront = new VictorSPX(0);
        leftBack = new VictorSPX(1);
        rightFront = new VictorSPX(2);
        rightBack = new VictorSPX(3);
    }

    public void tankDrive(double left, double right)
    {
        leftFront.set(ControlMode.PercentOutput, left);
        leftBack.set(ControlMode.PercentOutput, left);
        rightFront.set(ControlMode.PercentOutput, -right);
        rightBack.set(ControlMode.PercentOutput, -right);        

    }

    public void arcadeDrive(double straight, double left, double right)
    {
        leftFront.set(ControlMode.PercentOutput, (straight - left + right));
        leftBack.set(ControlMode.PercentOutput,  (straight - left + right));
        rightFront.set(ControlMode.PercentOutput, -(straight + left - right));
        rightBack.set(ControlMode.PercentOutput, -(straight + left - right));   
    }

}

