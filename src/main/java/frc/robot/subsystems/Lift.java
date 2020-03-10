/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LiftConstants;

public class Lift extends SubsystemBase {

  private static WPI_TalonSRX lift;

  /**
   * 
   * Lift Subsystem
   * 
   */

  public Lift() {


      lift = new WPI_TalonSRX(LiftConstants.ID);
      lift.setNeutralMode(NeutralMode.Brake);


  }
  //moves lift
  public void liftMove(double speed) {

    lift.set(speed);

  }

  @Override
  public void periodic() {
  }
}
