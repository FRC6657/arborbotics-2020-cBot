/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.rmi.dgc.DGC;

import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.CustomClasses.XCon;
import frc.robot.CustomClasses.XCon.DPAD;
import frc.robot.CustomClasses.XCon.DirectionalPad;
import frc.robot.CustomClasses.XCon.HAND;
import frc.robot.CustomClasses.XCon.Thumbstick;
import frc.robot.CustomClasses.XCon.Trigger;
import frc.robot.CustomClasses.XCon.DirectionalPad.DPadButton;
import frc.robot.commands.Agipotate;
import frc.robot.commands.IntakePowercells;
import frc.robot.commands.LiftControl;
import frc.robot.commands.OuttakePowercells;
import frc.robot.commands.PivotControlPanel;
import frc.robot.commands.ServoShifter;
import frc.robot.commands.SpinControlPanel;
import frc.robot.commands.TeleopDrive;
//import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final Agipotato s_Agipotato = new Agipotato();
  private final ControlPanel s_ControlPanel = new ControlPanel();
  private final Drivetrain s_Drivetrain = new Drivetrain();
  private final Intake s_Intake = new Intake();
  private final Lift s_Lift = new Lift();
  private final Outtake s_Outtake = new Outtake();

  private final Joystick joyStick = new Joystick(0);

  private final XCon controller = new XCon(1);
  private final Thumbstick rightThumbStick = new Thumbstick(controller,HAND.RIGHT);
  private final Thumbstick leftThumbStick = new Thumbstick(controller, HAND.LEFT);
  private final DirectionalPad dPad = new DirectionalPad(controller);
  private final Trigger leftTrigger = new Trigger(controller, HAND.LEFT);
  private final Trigger rightTrigger = new Trigger(controller, HAND.RIGHT);


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    controller.setRumble(HAND.LEFT, 1);
    controller.setRumble(HAND.RIGHT, 1);

    rightThumbStick.setYDeadZone(0.1);
    leftThumbStick.setXDeadZone(0.2);

    rightTrigger.setTriggerDeadZone(0.1);
    leftTrigger.setTriggerDeadZone(0.1);

    s_Drivetrain.setDefaultCommand(new TeleopDrive(s_Drivetrain,
    () -> rightThumbStick.getX(),
    () -> leftTrigger.getX(),
    () -> rightThumbStick.getY(),
    () -> rightThumbStick.get()));

    s_Lift.setDefaultCommand(new LiftControl(s_Lift,
    () ->  -0.75 * leftThumbStick.getX()));

  }

  private void configureButtonBindings() {

    System.out.println("Binds Configured");

    final JoystickButton a = new JoystickButton(controller, XboxController.Button.kA.value);
    final JoystickButton b = new JoystickButton(controller, XboxController.Button.kB.value);
    final JoystickButton x = new JoystickButton(controller, XboxController.Button.kX.value);
    final JoystickButton y = new JoystickButton(controller, XboxController.Button.kY.value);
    final JoystickButton lStickPress = new JoystickButton(controller, XboxController.Button.kStickLeft.value);
    final JoystickButton rStickPress = new JoystickButton(controller, XboxController.Button.kStickRight.value);
    final JoystickButton lBumper = new JoystickButton(controller, XboxController.Button.kBumperLeft.value);
    final JoystickButton rBumper = new JoystickButton(controller, XboxController.Button.kBumperRight.value);
    final JoystickButton back = new JoystickButton(controller, XboxController.Button.kBack.value);
    final JoystickButton start = new JoystickButton(controller, XboxController.Button.kBack.value);
    final DPadButton dPadUp = new DPadButton(dPad, DPAD.UP);
    final DPadButton dPadDown = new DPadButton(dPad, DPAD.DOWN);
    final DPadButton dPadLeft = new DPadButton(dPad, DPAD.LEFT);
    final DPadButton dPadRight = new DPadButton(dPad, DPAD.RIGHT);

    final JoystickButton trigger = new JoystickButton(joyStick, 1);
    final JoystickButton side = new JoystickButton(joyStick, 2);
    final JoystickButton topLeft = new JoystickButton(joyStick,3);
    final JoystickButton topRight = new JoystickButton(joyStick,4);
    final JoystickButton bottomLeft = new JoystickButton(joyStick,5);
    final JoystickButton bottomRight = new JoystickButton(joyStick,6);
    final JoystickButton _7 = new JoystickButton(joyStick,7);
    final JoystickButton _8 = new JoystickButton(joyStick,8);
    final JoystickButton _9 = new JoystickButton(joyStick,9);
    final JoystickButton _10 = new JoystickButton(joyStick,10);
    final JoystickButton _11 = new JoystickButton(joyStick,11);
    final JoystickButton _12 = new JoystickButton(joyStick,12);

      lBumper.whenHeld(new IntakePowercells(s_Intake));
      rBumper.whenHeld(new OuttakePowercells(s_Outtake));
      rBumper.toggleWhenActive(new ServoShifter(s_Outtake));
      rBumper.whenHeld(new Agipotate(s_Agipotato));
      a.whenHeld(new PivotControlPanel(s_ControlPanel, -0.4).withTimeout(2));
      y.whenHeld(new PivotControlPanel(s_ControlPanel, 0.4).withTimeout(1.8));
      x.whenHeld(new SpinControlPanel(s_ControlPanel, -0.2));
      b.whenHeld(new SpinControlPanel(s_ControlPanel, 0.2));
      dPadUp.whileHeld(new OuttakePowercells(s_Outtake));
  } 

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;//m_autoCommand;
  }
}
