package robot;
import robot.subsystems.*;
public class Operator {
    public static final double ARM_TOP_ROCKET_BALL = 0;
    public static final double ARM_MID_ROCKET_BALL = 0;
    public static final double ARM_BOT_ROCKET_BALL = 0;
    //--------------------------------------------------------------
    //public static final double ARM_TOP_ROCKET_HATCH = ;
    public static final double ARM_MID_ROCKET_HATCH = 0;
    public static final double ARM_BOT_ROCKET_HATCH = 0;
    public static final double WRIST_MID_ROCKET_HATCH = 0;
    public static final double WRIST_BOT_ROCKET_HATCH = 0;
    //--------------------------------------------------------------
    public static final double ARM_CARGO_BALL = 0;
    public static final double ARM_CARGO_HATCH = 0;
    public static final double WRIST_CARGO_BALL = 0;
    public static final double WRIST_CARGO_HATCH = 0;
    //--------------------------------------------------------------
    public static final double WRIST_TOP_ROCKET_BALL = 0;
    public static final double WRIST_MID_ROCKET_BALL = 0;
    public static final double WRIST_BOT_ROCKET_BALL = 0;

    //--------------------------------------------------------------
    public static final double ARM_STARTUP = 0;
    public static final double WRIST_STARTUP = 0;
    //--------------------------------------------------------------
    public static final double WHEELS_SPEED_IN = 0;
    public static final double WHEELS_SPEED_OUT = 0;


    Controller op = new Controller(1);
    Arm arm = new Arm();
    HatchMechanism hatch = new HatchMechanism();
    Wheels wheels = new Wheels();
    Wrist wrist = new Wrist();
    public void runOpControls() {

        if (op.getDPadUp()) {
            arm.setPosition(ARM_TOP_ROCKET_BALL);
            wrist.setPosition(WRIST_TOP_ROCKET_BALL);
        }
        else if (op.getDPadLeft()) {
            arm.setPosition(ARM_MID_ROCKET_BALL);
            wrist.setPosition(WRIST_MID_ROCKET_BALL);
        }
        else if (op.getDPadDown()) {
            arm.setPosition(ARM_BOT_ROCKET_BALL);
            wrist.setPosition(WRIST_BOT_ROCKET_BALL);
        }
        else if (op.getDPadRight()) {
            arm.setPosition(ARM_CARGO_BALL);
            wrist.setPosition(WRIST_CARGO_BALL);
        }
        //if (){
        arm.override(op.getLeftYAxis());
        wrist.override(op.getRightYAxis());
        //}
        //------------------------------------------------------
        if (op.getRightBumper()) {
            wheels.runWheels(WHEELS_SPEED_IN);
        }
        wheels.runWheels(op.getRightTrigger());
        //------------------------------------------------------

        if (op.getOButton()) {
            arm.setPosition(ARM_MID_ROCKET_HATCH);
            wrist.setPosition(WRIST_MID_ROCKET_HATCH);
        }
        else if (op.getXButton()) {
            arm.setPosition(ARM_BOT_ROCKET_HATCH);
            wrist.setPosition(WRIST_BOT_ROCKET_HATCH);
        }
        else if (op.getSquareButton()) {
            arm.setPosition(ARM_CARGO_HATCH);
            wrist.setPosition(WRIST_CARGO_HATCH);
        }
        //------------------------------------------------------
        if (op.getLeftBumper()) {
            hatch.place();
        }
        else {
            hatch.retract();
        }

    }


    
}