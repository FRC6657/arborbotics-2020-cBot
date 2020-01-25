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
public class Chicken2 extends Subsystem {
  private WPI_TalonSRX whip = new WPI_TalonSRX(IDs.whip.value);

  public void whipOn(double speed){
    whip.set(speed);
  }

  public void whipOff(){
    whip.set(0);
  }

  @Override
  public void initDefaultCommand() {
  }
}
