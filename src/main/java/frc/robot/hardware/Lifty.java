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
public class Lifty extends Subsystem {
  
  private WPI_TalonSRX liftMotor = new WPI_TalonSRX(IDs.liftMotor.value);

  public void liftUp(double speed){
    liftMotor.set(speed);
  }

  public void liftDown(double speed){
    liftMotor.set(-speed);
  }

  public void stop(){
    liftMotor.set(0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
