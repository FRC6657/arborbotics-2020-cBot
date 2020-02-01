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
public class ControlPanel extends Subsystem {

  private WPI_TalonSRX pivot = new WPI_TalonSRX(IDs.controlPanelPivot.value);
  private WPI_TalonSRX theStack = new WPI_TalonSRX(IDs.controlPanelSpin.value);

  @Override
  public void initDefaultCommand() {
  }

  public void pivotUp(double speed){
    pivot.set(speed);
  }

  public void pivotStop(){
    pivot.set(0);
  }

  public void stackOn(double speed){
    theStack.set(speed);
  }

  public void stacKOff(){
    theStack.set(0);
  }
}
