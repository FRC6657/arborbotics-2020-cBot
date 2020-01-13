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

public class Controllers extends Subsystem {//Handes the drivers inputs and binds those inputs to commands
  
  private Joystick joyStick;//Declares the Joystick

  public boolean getJoyButton(int button){return joyStick.getRawButton(button);}//Gets if the given button was the last pressed

  public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}//Gets the current axis position of a given access

  //Creates joystick buttons for every robot function that will need one
  public JoystickButton outtakeOut;
  public JoystickButton outtakeIn;
  public JoystickButton intakeOut;
  public JoystickButton intakeIn;
  public JoystickButton intakePivotUp;
  public JoystickButton intakePivotDown;
  
  public Controllers(){

    joyStick = new Joystick(IDs.joyStick.value);//Binds the Joystick to its driverstation ID

    //Binds each Joystick button to a Binding located in the ControllerBinds Enum
    outtakeOut = new JoystickButton(joyStick, ControllerBinds.intakeOut.value);
    outtakeIn = new JoystickButton(joyStick, ControllerBinds.intakeIn.value);
    intakeOut = new JoystickButton(joyStick, ControllerBinds.intakeOut.value);
    intakeIn = new JoystickButton(joyStick, ControllerBinds.intakeIn.value);
    intakePivotUp = new JoystickButton(joyStick, ControllerBinds.intakePivotUp.value);
    intakePivotDown = new JoystickButton(joyStick, ControllerBinds.intakePivotDown.value);

    //Shortens commands into simple 2 letter names
    OuttakeOut oo = new OuttakeOut();
    OuttakeIn oi = new OuttakeIn();
    IntakeOut io = new IntakeOut();
    IntakeIn ii = new IntakeIn();
    IntakePivotUp ipu = new IntakePivotUp();
    IntakePivotDown ipd = new IntakePivotDown();

    //Binds each button with a command
    outtakeOut.whileHeld(oo);
    outtakeIn.whileHeld(oi);
    intakeOut.whileHeld(io);
    intakeIn.whileHeld(ii);
    intakePivotUp.whileHeld(ipu);
    intakePivotDown.whileHeld(ipd);

  }

  @Override
  public void initDefaultCommand() {}
}
