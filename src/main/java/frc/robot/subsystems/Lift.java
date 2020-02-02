/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {

  private SpeedController Lift;

  public Lift() {

    Lift = new WPI_TalonSRX(6);

  }

  public void LiftUp(double speed){

    Lift.set(-speed);

  }

  public void LiftDown(double speed){

    Lift.set(speed);

  }

  @Override
  public void periodic() {}
}
