/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2658.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public Talon bLMotor, bRMotor, fLMotor, fRMotor;
	public Joystick jStick;
	public final int B_LEFT_PORT = 8, B_RIGHT_PORT = 9, F_RIGHT_PORT = 1, F_LEFT_PORT = 0;
	public final int JOYSTICK_PORT = 0, GYRO_PORT = 0;
	public MecanumDrive mecDrive;
	public Gyro gyro;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		bLMotor = new Talon(B_LEFT_PORT);
		bRMotor = new Talon(B_RIGHT_PORT);
		fRMotor = new Talon(F_RIGHT_PORT);
		fLMotor = new Talon(F_LEFT_PORT);
		
		jStick = new Joystick(JOYSTICK_PORT);
		
		gyro = new AnalogGyro(GYRO_PORT);
		gyro.reset();
		
		mecDrive = new MecanumDrive(fLMotor, bLMotor, fRMotor, bRMotor);
	}


	@Override
	public void autonomousInit() {
		
		
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
//   	       front 
// 		fLMotor      fRMotor
// 			0--------0
// 			|--------|
// 			|--------|
// 			|--------|
// 			0--------0
// 		 bLMotor     bRMotor
		
		
		// add gyro param if needed
		
		mecDrive.driveCartesian(-jStick.getRawAxis(1), jStick.getRawAxis(0), jStick.getRawAxis(2));
		bRMotor.set(0.15);
		bLMotor.set(0.15);
		fRMotor.set(0.15);
		fLMotor.set(0.15);
	}
	
	
	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
