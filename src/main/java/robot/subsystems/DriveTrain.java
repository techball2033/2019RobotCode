package robot.subsystems;  

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

}

