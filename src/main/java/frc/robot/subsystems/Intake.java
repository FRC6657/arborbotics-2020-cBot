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

public class Intake extends SubsystemBase {

  private SpeedController Intake;

  public Intake() {

    Intake = new WPI_TalonSRX(5);

  }

  public void IntakeIn(double speed){

    Intake.set(speed);

  }

  public void OuttakeIn(double speed){

    Intake.set(-speed);

  }

  @Override
  public void periodic() {}
}
