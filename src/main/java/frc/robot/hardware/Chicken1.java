/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class Chicken1 extends Subsystem {

  private WPI_TalonSRX intakeSpin = new WPI_TalonSRX(5);
  private WPI_TalonSRX intakePivot = new WPI_TalonSRX(6);

  public void Spin(double speed){intakeSpin.set(speed);}

  public void Pivot(double speed){intakePivot.set(speed);}
  @Override
  public void initDefaultCommand() {
  }
}
