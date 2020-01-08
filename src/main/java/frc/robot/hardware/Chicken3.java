/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Chicken3 extends Subsystem {
  
  private WPI_TalonSRX outL = new WPI_TalonSRX(5);
  private WPI_TalonSRX outR = new WPI_TalonSRX(6);

  public void Out(double speed){outL.set(speed); outR.set(-speed);}
  public void In(double speed){outL.set(-speed); outR.set(speed);}

  @Override
  public void initDefaultCommand() {
  }
}
