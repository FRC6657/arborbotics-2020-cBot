/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants.IDs;

/**
 * Add your docs here.
 */
public class Chicken3 extends Subsystem {
  
  private WPI_TalonSRX outL = new WPI_TalonSRX(IDs.outtakeL.value);
  private WPI_TalonSRX outR = new WPI_TalonSRX(IDs.outtakeR.value);

  public void Out(double speed){outL.set(speed); outR.set(speed);}
  public void In(double speed){outL.set(-speed); outR.set(-speed);}
  public void Stop(){outL.set(0);outR.set(0);}

  @Override
  public void initDefaultCommand() {
  }
}
