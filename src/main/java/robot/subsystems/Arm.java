package robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Arm {

    private WPI_TalonSRX left;
    private WPI_TalonSRX right;

    private SpeedControllerGroup armGroup; 

    public Arm() {
        left = new WPI_TalonSRX(4);
        right = new WPI_TalonSRX(5);

        right.setInverted(true);//Inverting one motor as they drive in different directions. CHECK WHICH SIDE TO INVERT.

        armGroup = new SpeedControllerGroup(left, right);
    }

}