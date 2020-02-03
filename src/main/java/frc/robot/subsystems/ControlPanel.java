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

public class ControlPanel extends SubsystemBase {

  private SpeedController CPivot;
  private SpeedController CSpin;

  public ControlPanel() {

    CPivot = new WPI_TalonSRX(10);
    CSpin = new WPI_TalonSRX(11);

  }

  public void Spin(double speed){

    CSpin.set(speed);

  }
  public void Pivot(double speed){

    CPivot.set(speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
