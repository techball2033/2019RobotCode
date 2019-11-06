package robot.subsystems;  

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain {

    private WPI_VictorSPX leftFront;
    private WPI_VictorSPX leftBack;
    private WPI_VictorSPX rightFront;
    private WPI_VictorSPX rightBack;

    private SpeedControllerGroup leftSpeedGroup;            
    private SpeedControllerGroup rightSpeedGroup;

    private DifferentialDrive driveType;

    public DriveTrain() {
        leftFront = new WPI_VictorSPX(0);           //Each port in the victorSPX is what you talk to
        leftBack = new WPI_VictorSPX(1);
        rightFront = new WPI_VictorSPX(2);
        rightBack = new WPI_VictorSPX(3);

        //Redundant fix for drivetrain - put back in code if problems arise
        /*
        leftFront.setSafetyEnabled(false);
        leftBack.setSafetyEnabled(false);
        rightFront.setSafetyEnabled(false);
        rightBack.setSafetyEnabled(false);
        */

        leftSpeedGroup = new SpeedControllerGroup(leftFront,leftBack);      //Speed controller group is the motor controller groups
        //Front and back have to be equal
        rightSpeedGroup = new SpeedControllerGroup(rightFront,rightBack);
        //Speed groups will always be identical

        driveType = new DifferentialDrive(leftSpeedGroup,rightSpeedGroup);
        driveType.setSafetyEnabled(false);
    }

    public void tankDrive(double left, double right) {      //Takes in two parameters & input from the joysticks
        driveType.tankDrive(left, right);           //
    }

    public void arcadeDrive(double straight, double left, double right) { //Takes in two parameters & input from the joysticks & left/right trigger movement
        leftSpeedGroup.set(straight + left - right);
        rightSpeedGroup.set(-(straight - left + right)); 
    }

    public void arcadeDrive(double speed, double rotation) {
        driveType.arcadeDrive(speed, rotation);
    }
}
