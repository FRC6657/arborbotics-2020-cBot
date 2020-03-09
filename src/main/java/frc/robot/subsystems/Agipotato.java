/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Agipotato extends SubsystemBase {

  private WPI_TalonSRX Agipotato;

  public Agipotato() {
    if(RobotBase.isReal()){
      Agipotato = new WPI_TalonSRX(9);
    }
  }

  public void agipotate(double speed){

    Agipotato.set(speed);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
