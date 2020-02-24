/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {

  private static WPI_TalonSRX Lift = new WPI_TalonSRX(6);

  public Lift() {

    Lift.setNeutralMode(NeutralMode.Brake);

  }

  public void LiftMove(double speed) {

    Lift.set(speed);

  }

  public static double getLiftPosition() {

    return Lift.getSelectedSensorPosition();

  }


  @Override
  public void periodic() {


    //Shuffleboard.getTab("SmartDashboard").add("Encoder: ", Lift.getSelectedSensorPosition());

  }
}
