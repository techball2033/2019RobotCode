package robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
    public static Joystick joy;

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
        wheels = new Wheels();
        wrist = new Wrist();
        arm = new Arm();
        climber = new Climber();
        hatchMechanism = new HatchMechanism();

        //Joystick init
        joy = new Joystick(0);

        //Camera init
        CameraServer.getInstance().startAutomaticCapture();

        driveType = new SendableChooser<>();
        driveType.setDefaultOption("Arcade", arcade);
        driveType.addOption("Tank", tank);
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
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
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
    }

    private void joyStickDrive() {
        if(driveType.getSelected().equals(arcade))
            driveTrain.arcadeDrive(joy.getY(Hand.kRight), joy.getX(Hand.kRight));
        else if(driveType.getSelected().equals(tank))
            driveTrain.tankDrive(joy.getY(Hand.kLeft), joy.getY(Hand.kRight));
        else
            System.out.println("Error: No drive type chosen");
    }
}