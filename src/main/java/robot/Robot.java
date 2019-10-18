package robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    public static DriveTrain driveTrain;
    public static Wheels wheels;
    public static Wrist wrist;
    public static Arm arm;
    public static Climber climber;
    public static HatchMechanism hatchMechanism;
    public static Controller joy;
    public static Operator op;
    private SendableChooser<Byte> driveType;
    private final Byte arcade = 0;
    private final Byte tank = 1;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        //Subsystem init
        driveTrain = new DriveTrain();
        op = new Operator();

        //Joystick init
        joy = new Controller(0);

        //Camera init
        CameraServer.getInstance().startAutomaticCapture();

        driveType = new SendableChooser<>();
        driveType.setDefaultOption("Arcade", arcade);
        driveType.addOption("Tank", tank);
        SmartDashboard.putData("Drive Type", driveType);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        teleopInit();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
        teleopPeriodic();
    }

    @Override
    public void teleopInit() {
        arm.reset();
        wrist.reset();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        joyStickDrive();
        op.runOpControls();
    }

    private void joyStickDrive() {
        if(driveType.getSelected().equals(arcade))
            driveTrain.arcadeDrive(joy.getRightYAxis(), joy.getLeftTrigger(), joy.getRightTrigger());//CHECK IF JOYSTICK INPUT WORKS
        else if(driveType.getSelected().equals(tank))
            driveTrain.tankDrive(joy.getLeftYAxis(), joy.getRightYAxis());
        else
            System.out.println("Error: No drive type chosen");
    }

    private void joyStickWheels() {
        wheels.runWheels(joy.getRightTrigger()-joy.getLeftTrigger());
    }

    private void joyStickHatch() {
        if(joy.getDPadRight())
            hatchMechanism.place();
        else if(joy.getDPadLeft())
            hatchMechanism.retract();
    }

    private void joyStickClimb() {
        if(joy.getDPadUp())
            climber.climb();
        else if(joy.getDPadDown())
            climber.retract();
    }

    private void joyStickArm() {
        
    }
}