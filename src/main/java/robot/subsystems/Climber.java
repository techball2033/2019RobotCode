package robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Climber {

    private DoubleSolenoid climberSolenoid;

    public Climber() {
        climberSolenoid = new DoubleSolenoid(0, 0, 1);

    }

}

