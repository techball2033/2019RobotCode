package frc.robot.subsystems;  

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import frc.robot.RobotMap;


class DriveTrain<WPI_VictorSPX> {

    VictorSPX frontRight, frontLeft, backRight, backLeft;

    public DriveTrain() {
        frontRight = new VictorSPX (RobotMap.FRONT_RIGHT_DRIVE_TRAIN);
        frontLeft = new VictorSPX (RobotMap.FRONT_RIGHT_DRIVE_TRAIN);
        backRight = new VictorSPX (RobotMap.FRONT_RIGHT_DRIVE_TRAIN);
        backLeft = new VictorSPX (RobotMap.FRONT_RIGHT_DRIVE_TRAIN);
    }
}