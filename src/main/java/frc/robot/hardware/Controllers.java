/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.Constants.*;
import frc.robot.Commands.*;


/**
 * Add your docs here.
 */
public class Controllers extends Subsystem {
  
  private Joystick joyStick;

  public boolean getJoyButton(int button){return joyStick.getRawButton(button);}

  public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}

  public JoystickButton outtakeOut;
  public JoystickButton outtakeIn;
  public JoystickButton intakeOut;
  public JoystickButton intakeIn;
  public JoystickButton intakePivotUp;
  public JoystickButton intakePivotDown;
  
  public Controllers(){

    joyStick = new Joystick(IDs.joyStick.value);

    outtakeOut = new JoystickButton(joyStick, ControllerBinds.intakeOut.value);
    outtakeIn = new JoystickButton(joyStick, ControllerBinds.intakeIn.value);
    intakeOut = new JoystickButton(joyStick, ControllerBinds.intakeOut.value);
    intakeIn = new JoystickButton(joyStick, ControllerBinds.intakeIn.value);
    intakePivotUp = new JoystickButton(joyStick, ControllerBinds.intakePivotUp.value);
    intakePivotDown = new JoystickButton(joyStick, ControllerBinds.intakePivotDown.value);

    outtakeOut.whileHeld(new IntakeOut());
    outtakeIn.whileHeld(new IntakeIn());
    intakeOut.whileHeld(new IntakeOut());
    intakeIn.whileHeld(new IntakeIn());
    intakePivotUp.whileHeld(new IntakePivotUp());
    intakePivotDown.whileHeld(new IntakePivotDown());

  }

  @Override
  public void initDefaultCommand() {}
}
