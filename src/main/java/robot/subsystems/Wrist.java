package robot.subsystems;

import edu.wpi.first.wpilibj.Spark;

public class Wrist {
    private Spark wrist;

    public Wrist() {
        wrist = new Spark(1);
        wrist.setInverted(false);
    }


}

