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

  public double getJoyPOV(int pov){return joyStick.getPOV(pov);}

  public boolean getRawButtonReleased(int button){return joyStick.getRawButtonReleased(button);}
  public boolean getRawButtonPressed(int button){return joyStick.getRawButtonPressed(button);}

  public boolean button6status = false;

  public Controllers(){

    if(getRawButtonPressed(6)){button6status = true;}
    if(getRawButtonReleased(6)){button6status = false;}

  }

  @Override
  public void initDefaultCommand() {}
}
