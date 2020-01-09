/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants.Doubles;
import frc.robot.Constants.IDs;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */

public class Turkey1 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX turkeyOne = new WPI_TalonSRX(IDs.turkeyOneWheel.value);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void rotationControl() {
    long startTime = System.currentTimeMillis();
    long endTime = startTime + 15000;

    while(System.currentTimeMillis() < endTime){

      turkeyOne.set(1*Doubles.rotateCSpeed);

    }

  }
}
