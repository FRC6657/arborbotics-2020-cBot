/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants.*;

/**
 * Add your docs here.
 */
public class Controllers extends Subsystem {

  private Joystick joyStick = new Joystick(IDs.joyStick.value);


  public boolean getJoyButton(int button){return joyStick.getRawButton(button);}

  public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}

  @Override
  public void initDefaultCommand() {}
}
