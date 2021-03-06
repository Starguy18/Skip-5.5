package org.usfirst.frc3467.subsystems.Elevator.commands;

import org.usfirst.frc3467.commands.CommandBase;
import org.usfirst.frc3467.subsystems.Elevator.Elevator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class elevatorDrive extends CommandBase {

	double fixedSpeed = 0;
	
    public elevatorDrive() {
    	requires(elevator);
    	fixedSpeed = 0;
    }

    public elevatorDrive(double fSpeed) {
    	requires(elevator);
    	fixedSpeed = fSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	elevator.initManualMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = 0;
    	
    	if (fixedSpeed == 0)
			speed = -(oi.getGamepad().getLeftStickY());
    	else
			speed = fixedSpeed;

    	SmartDashboard.putNumber("Elevator Drive Stick", speed);
    	elevator.driveManual(speed);
 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.driveManual(Elevator.STOP);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
