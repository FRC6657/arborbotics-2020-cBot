/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants.IDs;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends Subsystem {

  private WPI_TalonSRX motorFL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  private WPI_TalonSRX motorFR = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  private WPI_TalonSRX motorBL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  private WPI_TalonSRX motorBR = new WPI_TalonSRX(IDs.frontLeftMotor.value);

  public DriveTrain(){

    motorBL.follow(motorFL);
    motorBR.follow(motorFR);
    
  }

  public void driveLeft(double speed){motorFL.set(speed);}
  public void driveRight(double speed){motorFR.set(-speed);}

  public void Drive(double leftSpeed, double rightSpeed){

    motorFL.set(leftSpeed);
    motorFR.set(-rightSpeed);

  }

  @Override
  public void initDefaultCommand() {}
}
