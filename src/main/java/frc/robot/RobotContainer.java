/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.CustomClasses.ACCTWEMAS;
import frc.robot.CustomClasses.DPad;
import frc.robot.CustomClasses.DPad.Direction;
import frc.robot.commands.Agipotate;
import frc.robot.commands.HighGear;
import frc.robot.commands.IntakeOuttake;
import frc.robot.commands.IntakePowercells;
import frc.robot.commands.LiftControl;
import frc.robot.commands.LiftMove;
import frc.robot.commands.LowGear;
import frc.robot.commands.NormalGear;
import frc.robot.commands.OuttakePowercells;
import frc.robot.commands.PivotControlPanel;
import frc.robot.commands.SpinControlPanel;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TeleopDriveStick;
//import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Agipotato;
import frc.robot.subsystems.ControlPanel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Outtake;


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
  private final XboxController controller = new XboxController(1);
  private final ACCTWEMAS XboxController = new ACCTWEMAS(1);
  private final String DriverProfile = "Andrew";
  public double speed;

  @SuppressWarnings("unused")
  public RobotContainer() {
    configureButtonBindings();
    //THIS WORKS™ \/
////*

    if (DriverProfile == "Andrew") {
      
      s_Drivetrain.setDefaultCommand(new TeleopDrive(s_Drivetrain,
       () -> (speed * deadBandApplicator(controller.getRawAxis(3),Constants.triggerDeadband)) - (speed * deadBandApplicator(controller.getRawAxis(2),Constants.triggerDeadband)),
        () -> speed * deadBandApplicator(controller.getRawAxis(4), Constants.stickDeadband),
         () -> controller.getRawButton(12)));
      
      s_Lift.setDefaultCommand(new LiftControl(s_Lift,
       () -> deadBandApplicator(controller.getRawAxis(1), Constants.stickDeadband)));
      
    }
    if (DriverProfile == "Single"){
      s_Drivetrain.setDefaultCommand(new TeleopDriveStick(s_Drivetrain,
        () -> 0.5 * deadBandApplicator(joyStick.getRawAxis(1),0.3),
          () -> 0.5 * deadBandApplicator(joyStick.getRawAxis(3),0.3)));
    }
    if (DriverProfile == "Double"){
      s_Drivetrain.setDefaultCommand(new TeleopDriveStick(s_Drivetrain,
        () -> 0.5 * deadBandApplicator(joyStick.getRawAxis(1),0.3),
          () -> 0.5 * deadBandApplicator(joyStick.getRawAxis(3),0.3)));
    }

//*/


    //THIS MOST LIKELY WONT \/
/*
    s_Drivetrain.setDefaultCommand(new TeleopDrive(s_Drivetrain,
    () -> 0.25 * XboxController.getJoystick(ACCTWEMAS.Side.LEFT, ACCTWEMAS.Axis.Y),
    () -> 0.25 * XboxController.getJoystick(ACCTWEMAS.Side.RIGHT, ACCTWEMAS.Axis.X),
    () -> XboxController.getButton(ACCTWEMAS.Button.R_JOYSTICK)));


    s_Lift.setDefaultCommand(new LiftControl(s_Lift,
    -0.75 * XboxController.getJoystick(ACCTWEMAS.Side.LEFT, ACCTWEMAS.Axis.Y)));
*/

  }
  @SuppressWarnings("unused")
  private void configureButtonBindings() {

    System.out.println("Binds Configured");

    final JoystickButton a = new JoystickButton(XboxController, ACCTWEMAS.Button.A.id);
    final JoystickButton b = new JoystickButton(XboxController, ACCTWEMAS.Button.B.id);
    final JoystickButton x = new JoystickButton(XboxController, ACCTWEMAS.Button.X.id);
    final JoystickButton y = new JoystickButton(XboxController, ACCTWEMAS.Button.Y.id);
    final JoystickButton lStickPress = new JoystickButton(XboxController, ACCTWEMAS.Button.L_JOYSTICK.id);
    final JoystickButton rStickPress = new JoystickButton(XboxController, ACCTWEMAS.Button.R_JOYSTICK.id);
    final JoystickButton lBumper = new JoystickButton(XboxController, ACCTWEMAS.Button.LB.id);
    final JoystickButton rBumper = new JoystickButton(XboxController, ACCTWEMAS.Button.RB.id);
    final JoystickButton back = new JoystickButton(XboxController, ACCTWEMAS.Button.BACK.id);
    final JoystickButton start = new JoystickButton(XboxController, ACCTWEMAS.Button.START.id);
    final DPad dPadUp = new DPad(XboxController, Direction.Up);
    final DPad dPadDown = new DPad(XboxController, Direction.Down);
    final DPad dPadLeft = new DPad(XboxController, Direction.Left);
    final DPad dPadRight = new DPad(XboxController, Direction.Right);

    final JoystickButton trigger = new JoystickButton(joyStick, 1);
    final JoystickButton side = new JoystickButton(joyStick, 2);
    final JoystickButton topLeft = new JoystickButton(joyStick, 3);
    final JoystickButton topRight = new JoystickButton(joyStick, 4);
    final JoystickButton bottomLeft = new JoystickButton(joyStick, 5);
    final JoystickButton bottomRight = new JoystickButton(joyStick, 6);
    final JoystickButton _7 = new JoystickButton(joyStick, 7);
    final JoystickButton _8 = new JoystickButton(joyStick, 8);
    final JoystickButton _9 = new JoystickButton(joyStick, 9);
    final JoystickButton _10 = new JoystickButton(joyStick, 10);
    final JoystickButton _11 = new JoystickButton(joyStick, 11);
    final JoystickButton _12 = new JoystickButton(joyStick, 12);

    if (DriverProfile == "Andrew"){

      lBumper.whenHeld(new IntakePowercells(s_Intake));
      rBumper.whenHeld(new OuttakePowercells(s_Outtake));
      dPadRight.whenHeld(new Agipotate(s_Agipotato));
      a.whenHeld(new PivotControlPanel(s_ControlPanel, -0.4).withTimeout(2));
      y.whenHeld(new PivotControlPanel(s_ControlPanel, 0.4).withTimeout(1.8));
      x.whenHeld(new SpinControlPanel(s_ControlPanel, -0.2));
      b.whenHeld(new SpinControlPanel(s_ControlPanel, 0.2));

      dPadRight.whenHeld(new IntakeOuttake(s_Intake));

      dPadUp.toggleWhenPressed(new HighGear(this,0.75));
      dPadDown.toggleWhenPressed(new LowGear(this,0.25));
      dPadUp.cancelWhenPressed(new HighGear(this,0.25));
      dPadDown.cancelWhenPressed(new HighGear(this, 0.75));

      dPadUp.and(dPadDown).whenInactive(new NormalGear(this));

    }
    if(DriverProfile == "Single"){

      trigger.whenHeld(new OuttakePowercells(s_Outtake));
      trigger.whenHeld(new Agipotate(s_Agipotato));
      side.whenHeld(new IntakePowercells(s_Intake));
      _12.whenHeld(new PivotControlPanel(s_ControlPanel, -0.4).withTimeout(2));
      _11.whenHeld(new PivotControlPanel(s_ControlPanel, 0.4).withTimeout(1.8));
      _10.whenHeld(new SpinControlPanel(s_ControlPanel, -0.2));
      _9.whenHeld(new SpinControlPanel(s_ControlPanel, 0.2));

    }
    if(DriverProfile == "Double"){

      
      lBumper.whenHeld(new IntakePowercells(s_Intake));
      rBumper.whenHeld(new OuttakePowercells(s_Outtake));
      dPadRight.whenHeld(new Agipotate(s_Agipotato));
      a.whenHeld(new PivotControlPanel(s_ControlPanel, -0.4).withTimeout(2));
      y.whenHeld(new PivotControlPanel(s_ControlPanel, 0.4).withTimeout(1.8));
      x.whenHeld(new SpinControlPanel(s_ControlPanel, -0.2));
      b.whenHeld(new SpinControlPanel(s_ControlPanel, 0.2));

      dPadUp.whenHeld(new LiftMove(s_Lift, 0.2));
      dPadDown.whenHeld(new LiftMove(s_Lift, -0.2));

    }

  }

  public double deadBandApplicator(double input, double deadband){

    if(Math.abs(input) < deadband){return 0;}
    if(Math.abs(input) > deadband){return input;}
    else{System.out.println("Deadband Exceded");return input;}

  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;// m_autoCommand;
  }
}
