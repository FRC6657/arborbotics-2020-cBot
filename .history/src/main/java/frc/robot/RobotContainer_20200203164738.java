/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Agipotate;
import frc.robot.commands.CameraSwitching;
import frc.robot.commands.IntakePowercells;
import frc.robot.commands.LiftControl;
import frc.robot.commands.OuttakePowercells;
import frc.robot.commands.PivotControlPanel;
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
  private final Cameras s_Cameras = new Cameras();

  private final XboxController controller = new XboxController(0);
  


  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    s_Drivetrain.setDefaultCommand(new TeleopDrive(s_Drivetrain,
    () -> -1 * controller.getY(GenericHID.Hand.kRight),
    () -> controller.getX(GenericHID.Hand.kLeft),
    () -> controller.getStickButton(GenericHID.Hand.kLeft)));

    s_Lift.setDefaultCommand(new LiftControl(s_Lift,
    () ->  0.5 * controller.getY(GenericHID.Hand.kRight)));

  }

  private void configureButtonBindings() {

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
    

    lBumper.whenHeld(new IntakePowercells(s_Intake));
    rBumper.whenHeld(new OuttakePowercells(s_Outtake));
    rBumper.whenPressed(new ServoShifter(s_Outtake));
    
    rBumper.whenHeld(new Agipotate(s_Agipotato));
    a.whenHeld(new PivotControlPanel(s_ControlPanel, -0.4).withTimeout(2));
    y.whenHeld(new PivotControlPanel(s_ControlPanel, 0.4).withTimeout(1.8));
    x.whenHeld(new SpinControlPanel(s_ControlPanel, -0.2));
    b.whenHeld(new SpinControlPanel(s_ControlPanel, 0.2));
    start.toggleWhenPressed(new CameraSwitching(s_Cameras));


  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;//m_autoCommand;
  }
}
