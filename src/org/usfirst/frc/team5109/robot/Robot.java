package org.usfirst.frc.team5109.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code. Testststseawerawefasdf
     */
	//RobotDrive myRobot;  // class that handles basic drive operations
    Joystick leftStick;  // set to ID 1 in DriverStation
    Joystick rightStick; // set to ID 2 in DriverStation
    Talon test1;
    Talon test7;
    double zLeft;
    double zRight;
    Encoder dioTest = new Encoder(0,1);
    Victor encoderMotor = new Victor(2); 
    DigitalInput button=new DigitalInput(4);
    public Robot() {
       // myRobot = new RobotDrive(2, 1);
       // myRobot.setExpiration(0.1);
        rightStick = new Joystick(0);
        leftStick = new Joystick(1);
        test1=new Talon(0);
        test7=new Talon(1);
        
    }

    
    /**
     * Runs the motors with tank steering.
     */
    public void operatorControl() {
       // myRobot.setSafetyEnabled(false);
       // while (isOperatorControl() && isEnabled()) {
       // 	myRobot.tankDrive(leftStick, rightStick);
       //     Timer.delay(0.005);		// wait for a motor update time
       // }
    }

    public void robotInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//test1.set(.4);
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	zLeft = ((leftStick.getThrottle() + 1)*.5);
    	zRight=((rightStick.getThrottle() + 1)*.5);
    	test1.set(leftStick.getY()*-1*zLeft);
    	test7.set(rightStick.getY()*zRight);
    	encoderMotor.set(rightStick.getZ());
    	SmartDashboard.putNumber("encoder stuff", dioTest.get());
    	
    	if(button.get()){
    		test1.set(leftStick.getY()*-1*zLeft);
    	}
    	else{
    		test1.set(0);
    	}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    //	test1.set(.4);
    }
    
}