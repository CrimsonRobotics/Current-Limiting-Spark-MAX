/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;

/**
 * An example subsystem. You can replace with me with your own subsystem.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  CANSparkMax fR;
  CANSparkMax bR;
  CANSparkMax fL;
  CANSparkMax bL;

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive drive;

  public Drivetrain(int fLId, int fRId, int bLId, int bRId) {

    // Defining motors
    fL = new CANSparkMax(fLId, MotorType.kBrushless);
    fR = new CANSparkMax(fRId, MotorType.kBrushless);
    bL = new CANSparkMax(bLId, MotorType.kBrushless);
    bR = new CANSparkMax(bRId, MotorType.kBrushless);

    // Inverting some motors so that gears don't run against each other
    fL.setInverted(false);
    fR.setInverted(true);
    bL.setInverted(false);
    bR.setInverted(true);

    // Putting motors to follow each other
    leftMotors = new SpeedControllerGroup(fL, bL);
    rightMotors = new SpeedControllerGroup(fR, bR);

    drive = new DifferentialDrive(leftMotors, rightMotors);
    
  }

  public void Driving(Joystick leftDriver, Joystick rightDriver) {

    // Drivertrain things
    drive.arcadeDrive(rightDriver.getX(), -leftDriver.getY(), true);
  


    // Outputing the current of each motor in amps
    SmartDashboard.putNumber("Current Front Left: ", fL.getOutputCurrent());
    SmartDashboard.putNumber("Current Front Right: ", fR.getOutputCurrent());
    SmartDashboard.putNumber("Current Back Left: ", bL.getOutputCurrent());
    SmartDashboard.putNumber("Current Back Right: ", bR.getOutputCurrent());

  }

  @Override
  protected void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Driving());
  }
}
