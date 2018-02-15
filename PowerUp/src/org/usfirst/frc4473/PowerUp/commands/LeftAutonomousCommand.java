// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4473.PowerUp.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4473.PowerUp.Robot;
import org.usfirst.frc4473.PowerUp.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class LeftAutonomousCommand extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	private final DifferentialDrive roboDrive = RobotMap.driveroboDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public LeftAutonomousCommand() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Robot.driveEnc.reset();
    	
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if(gameData.length() > 0)
        {
    		if(switchIsOnLeft(gameData))
    		{
    			doSwitchOnLeft();
    		}
    		else 
    		{
    			doSwitchOnRight();
    		}
		} 
		else 
		{
			doSwitchUnknown();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() 
    {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() 
    {
    	Robot.drive.stop();
    }
    
    private boolean switchIsOnLeft(String gameData) {
    	return (gameData.charAt(0) == 'L');
    }
    
    private void doSwitchOnLeft() {    			
    	//Drive directions
		if(Robot.driveEnc.getDistance() <= 120)
		{
			roboDrive.tankDrive(1,1); 
		}
		else
		{
			Robot.drive.stop();
		}
    }
    
    private void doSwitchOnRight() {    			
    	//Drive directions
		if(Robot.driveEnc.getDistance() <= 120)
		{
			
		}
		else
		{
			Robot.drive.stop();
		}
    }
    
    private void doSwitchUnknown() {
		//Drive directions
    }
}