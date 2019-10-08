package robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Arm {

    private TalonSRX left;
    private TalonSRX right;

    public Arm() {
        left = new TalonSRX(4);
        right = new TalonSRX(5);
    }

}

