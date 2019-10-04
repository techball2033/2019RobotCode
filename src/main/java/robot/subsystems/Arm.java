package robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Arm extends Subsystem {

    private TalonSRX left;
    private TalonSRX right;

    public Arm() {
        left = new TalonSRX(4);
        right = new TalonSRX(5);
    }

}

