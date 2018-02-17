// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4473.PowerUp;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4473.PowerUp.commands.LeftAutonomousCommand;
import org.usfirst.frc4473.PowerUp.commands.MiddleAutonomousCommand;
import org.usfirst.frc4473.PowerUp.commands.RightAutonomousCommand;
import org.usfirst.frc4473.PowerUp.commands.grabEngage;
import org.usfirst.frc4473.PowerUp.subsystems.*;
import edu.wpi.first.wpilibj.Encoder;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    
    Command grabEngage;
    Command grabRelease; 
    Command liftUp;
    Command liftDown;
    
    static SendableChooser<Command> chooser;
    
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static drive drive;
    public static lift lift;
    public static climbLift climbLift;
    public static arm arm;
    
    public static Encoder driveEncLeft;
    public static Encoder driveEncRight;
  
    //DigitalInput limitSwitch;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    @SuppressWarnings("deprecation") //Removes yellow lines
    public void robotInit() {
        RobotMap.init();
        
        // INIT needs to be called before everything.
        
        chooser = new SendableChooser<Command>();
        
        driveEncLeft = new Encoder(2,3,false, Encoder.EncodingType.k2X);
        LiveWindow.addSensor("driveEncLeft", "driveEncLeft", (Encoder) driveEncLeft);
        
        driveEncRight = new Encoder(1,2,false, Encoder.EncodingType.k2X);
        LiveWindow.addSensor("driveEncRight", "driveEncRight", (Encoder) driveEncRight);

        
        chooser.addDefault("MiddleAutonomousCommand", new MiddleAutonomousCommand()); //Command no exist in steam works before this and fine but in power up it be a no no
        chooser.addObject("RightAutonomousCommand", new RightAutonomousCommand());
        chooser.addObject("LeftAutonomousCommand", new LeftAutonomousCommand());
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drive = new drive();
        lift = new lift();
        arm = new arm();
        climbLift = new climbLift();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        
        grabEngage = new grabEngage(); 
        grabRelease = new org.usfirst.frc4473.PowerUp.commands.grabRelease();//I don't know for some reason would not accept the same way as grabEngage
        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
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
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
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
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        
        //new driveTank();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        //processHug();
    	
        Scheduler.getInstance().run();
       
    }
    
    public void processHug()
    {
    	if (oi.secondaryGamepad.getRawButton(3))
        {
        	grabEngage.start(); 
        }
    	if (oi.secondaryGamepad.getRawButton(2))
    	{
    		grabRelease.start();
    	}
    }
}
