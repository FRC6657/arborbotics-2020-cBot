/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Agipotate;
import frc.robot.commands.IntakePowercells;
import frc.robot.commands.OuttakePowercells;
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
  // The robot's subsystems and commands are defined here...
  private final Agipotato s_Agipotato = new Agipotato();
  private final Drivetrain s_Drivetrain = new Drivetrain();
  private final Intake s_Intake = new Intake();
  private final Lift s_Lift = new Lift();
  private final Outtake s_Outtake = new Outtake();

  private final XboxController controller = new XboxController(0);

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);



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

    SmartDashboard.putData(s_Agipotato);
    SmartDashboard.putData(s_Drivetrain);
    SmartDashboard.putData(s_Intake);
    SmartDashboard.putData(s_Lift);
    SmartDashboard.putData(s_Outtake);

  }

  private void configureButtonBindings() {

    final JoystickButton a = new JoystickButton(controller, XboxController.Button.kA.value);
    final JoystickButton b = new JoystickButton(controller, XboxController.Button.kB.value);
    final JoystickButton x = new JoystickButton(controller, XboxController.Button.kX.value);

    a.whenHeld(new IntakePowercells(s_Intake));
    b.whenHeld(new OuttakePowercells(s_Outtake));
    x.whenHeld(new Agipotate(s_Agipotato));
    


  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;//m_autoCommand;
  }
}
