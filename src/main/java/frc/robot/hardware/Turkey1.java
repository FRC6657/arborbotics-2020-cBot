/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants.IDs;

/**
 * Add your docs here.
 */
public class Turkey1 extends Subsystem {

  private WPI_TalonSRX turkeyOneWheel = new WPI_TalonSRX(IDs.turkeyOneWheel);

  @Override
  public void initDefaultCommand() {}
}
