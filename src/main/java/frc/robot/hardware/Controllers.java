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

  JoystickButton Intake;
  JoystickButton Outtake;

  JoystickButton RotationControl;

  //Command intakeIn = new IntakeIn();
  //Command intakeOut = new IntakeOut();
  
  private Joystick joyStick = new Joystick(IDs.joyStick.value);

  public boolean getJoyButton(int button){return joyStick.getRawButton(button);}

  public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}

  public Controllers(){

    Intake = new JoystickButton(joyStick, 4);
    Outtake = new JoystickButton(joyStick, 6);

    //RotationControl = new JoystickButton(joyStick, IDs.rotationControlButton.value);

    //RotationControl rotationControl = new RotationControl();

    //RotationControl.whileHeld(rotationControl);

  //  Intake.whileHeld(intakeIn);
  //  Outtake.whileHeld(intakeOut);

  }

  @Override
  public void initDefaultCommand() {}
}
