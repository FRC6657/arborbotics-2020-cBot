/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

//War
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.custom_classes.ACCTWEMAS;
import frc.robot.custom_classes.DPad;
import frc.robot.custom_classes.DPad.Direction;
import frc.robot.Constants.AgitatorConstants;
import frc.robot.Constants.ControlPanelConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.JoystickButtons;
import frc.robot.Constants.LiftConstants;
import frc.robot.commands.Agipotate;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeOuttake;
import frc.robot.commands.IntakePowercells;
import frc.robot.commands.IntakeServo;
import frc.robot.commands.LiftControl;
import frc.robot.commands.LiftMove;
import frc.robot.commands.OuttakePowercells;
import frc.robot.commands.OuttakeServo;
import frc.robot.commands.PivotControlPanel;
import frc.robot.commands.SpinControlPanel;
import frc.robot.commands.SpinTillColor;
import frc.robot.commands.SwitchDriveDirection;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TurnCommand;
import frc.robot.subsystems.Agipotato;
import frc.robot.subsystems.Camera_Intake;
import frc.robot.subsystems.Camera_Outtake;
import frc.robot.subsystems.ColorThings;
import frc.robot.subsystems.ControlPanel;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Outtake;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  public static PowerDistributionPanel PDP = new PowerDistributionPanel();
  // The robot's subsystems
  private final Agipotato s_Agipotato = new Agipotato();
  private final ControlPanel s_ControlPanel = new ControlPanel();
  private final Drivetrain s_Drivetrain = new Drivetrain();
  private final Intake s_Intake = new Intake();
  private final Lift s_Lift = new Lift();
  private final Outtake s_Outtake = new Outtake();
  private final Camera_Intake s_Camera_Intake = new Camera_Intake();
  private final Camera_Outtake s_Camera_Outtake = new Camera_Outtake();
  private final ColorThings s_colorthings = new ColorThings();

  private final Joystick joyStick = new Joystick(0);
  private final static XboxController controller = new XboxController(1);
  private final ACCTWEMAS XboxController = new ACCTWEMAS(1);

  public final static String DriverProfile = "Main";

  public boolean outtakeCameraPos = true;
  public boolean intakeCameraPos = true;

  public double speed;

  @SuppressWarnings("unused")
  public RobotContainer() {
    configureButtonBindings();
    // THIS WORKS™ \/

    if (DriverProfile == "Test") {
      s_Drivetrain.setDefaultCommand(new TeleopDrive(s_Drivetrain,
          () -> ((deadBandApplicator(-DriveConstants.DRIVE_MULTIPLIER * controller.getTriggerAxis(Hand.kRight), DriveConstants.TRIGGER_DEADBAND))
             - (deadBandApplicator((-DriveConstants.TURN_MULTIPLIER * controller.getTriggerAxis(Hand.kLeft)), DriveConstants.TRIGGER_DEADBAND))),
          () -> (deadBandApplicator(DriveConstants.TURN_MULTIPLIER * controller.getX(GenericHID.Hand.kRight), DriveConstants.STICK_DEADBAND))));
    }
    s_Lift.setDefaultCommand(
        new LiftControl(s_Lift, () -> -deadBandApplicator(controller.getY(GenericHID.Hand.kLeft), DriveConstants.STICK_DEADBAND)));
    if (DriverProfile == "Main") {

      s_Drivetrain.setDefaultCommand(new TeleopDrive(s_Drivetrain, 
              () -> DriveConstants.DRIVE_MULTIPLIER * deadBandApplicator(joyStick.getRawAxis(DriveConstants.DRIVE_AXIS), DriveConstants.STICK_DEADBAND),
              () -> DriveConstants.TURN_MULTIPLIER * deadBandApplicator(joyStick.getRawAxis(DriveConstants.TURN_AXIS), DriveConstants.TWIST_DEADBAND)));

    }
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

    final JoystickButton trigger = new JoystickButton(joyStick, JoystickButtons.TRIGGER);
    final JoystickButton side = new JoystickButton(joyStick, JoystickButtons.SIDE);
    final JoystickButton topLeft = new JoystickButton(joyStick, JoystickButtons.TOP_LEFT);
    final JoystickButton topRight = new JoystickButton(joyStick, JoystickButtons.TOP_RIGHT);
    final JoystickButton bottomLeft = new JoystickButton(joyStick, JoystickButtons.BOTTOM_LEFT);
    final JoystickButton bottomRight = new JoystickButton(joyStick, JoystickButtons.BOTTOM_RIGHT);
    final JoystickButton _7 = new JoystickButton(joyStick, JoystickButtons._7);
    final JoystickButton _8 = new JoystickButton(joyStick, JoystickButtons._8);
    final JoystickButton _9 = new JoystickButton(joyStick, JoystickButtons._9);
    final JoystickButton _10 = new JoystickButton(joyStick, JoystickButtons._10);
    final JoystickButton _11 = new JoystickButton(joyStick, JoystickButtons._11);
    final JoystickButton _12 = new JoystickButton(joyStick, JoystickButtons._12);

    if (DriverProfile == "Test") {

      //lBumper.whenHeld(new IntakePowercells(s_Intake));
      //rBumper.whenHeld(new OuttakePowercells(s_Outtake));
      dPadRight.whenHeld(new Agipotate(s_Agipotato, () -> AgitatorConstants.SPEED));
      dPadLeft.whenHeld(new Agipotate(s_Agipotato, () -> -AgitatorConstants.SPEED));
      a.whenHeld(new PivotControlPanel(s_ControlPanel, -ControlPanelConstants.PIVOT_SPEED).withTimeout(2));
      y.whenHeld(new PivotControlPanel(s_ControlPanel, ControlPanelConstants.PIVOT_SPEED).withTimeout(1.8));
      x.whenHeld(new SpinControlPanel(s_ControlPanel, -ControlPanelConstants.ROTATE_SPEED));
      b.whenHeld(new SpinControlPanel(s_ControlPanel, ControlPanelConstants.ROTATE_SPEED));

      dPadDown.whenHeld(new IntakeOuttake(s_Intake, IntakeConstants.SPEED).withTimeout(0.05));
      dPadUp.toggleWhenPressed(new SpinTillColor(s_ControlPanel, s_colorthings));

      

      //rBumper.toggleWhenPressed(new OuttakeServo(s_Camera_Servos));
      //lBumper.toggleWhenPressed(new IntakeServo(s_Camera_Servos));
/*
      start.whenHeld(new ChangeOuttakeCameraState(s_Camera_Servos, true));
      back.whenHeld(new ChangeOuttakeCameraState(s_Camera_Servos, false));
      _9.whenHeld(new ChangeIntakeCameraState(s_Camera_Servos, true));
      _10.whenHeld(new ChangeIntakeCameraState(s_Camera_Servos, false));
*/
    }
    if (DriverProfile == "Main") {

      lBumper.whenHeld(new IntakePowercells(s_Intake, IntakeConstants.SPEED));
      rBumper.whenHeld(new OuttakePowercells(s_Outtake));
      dPadRight.whenHeld(new Agipotate(s_Agipotato, () -> AgitatorConstants.SPEED));
      dPadLeft.whenHeld(new Agipotate(s_Agipotato, () -> -AgitatorConstants.SPEED));
      a.whenHeld(new PivotControlPanel(s_ControlPanel, -ControlPanelConstants.PIVOT_SPEED).withTimeout(2));
      y.whenHeld(new PivotControlPanel(s_ControlPanel, ControlPanelConstants.PIVOT_SPEED).withTimeout(1.8));
      x.whenHeld(new SpinControlPanel(s_ControlPanel, -ControlPanelConstants.ROTATE_SPEED));
      b.whenHeld(new SpinControlPanel(s_ControlPanel, ControlPanelConstants.ROTATE_SPEED));
      dPadUp.whenHeld(new LiftMove(s_Lift, LiftConstants.SPEED));
      dPadDown.whenHeld(new LiftMove(s_Lift, LiftConstants.SPEED));

      _12.toggleWhenPressed(new OuttakeServo(s_Camera_Outtake));
      _11.toggleWhenPressed(new IntakeServo(s_Camera_Intake));
      _10.whenPressed(new SwitchDriveDirection(s_Drivetrain));
      _9.toggleWhenPressed(new SpinTillColor(s_ControlPanel, s_colorthings));

      start.whenHeld(new IntakeOuttake(s_Intake,IntakeConstants.SPEED).withTimeout(0.05));

    }
  }

  public double deadBandApplicator(double input, double deadband) {

    if (Math.abs(input) < deadband) {
      return 0;
    }
    if (Math.abs(input) > deadband) {
      return input;
    } else {
      System.out.println("Deadband Exceded");
      return input;
    }

  }

  public static double getControllerVal(int axis) {
    return controller.getRawAxis(axis);
  }

  public static double getControllerVal(Hand hand, String axis) {

    if (axis == "X") {
      return controller.getX(hand);
    }
    if (axis == "Y") {
      return controller.getY(hand);
    } else {
      System.out.println("Invalid Axis Given In RobotController.getControllerVal(hand, string)");
      return 0.0;
    }

  }

  public static double getControllerTriggerVal(Hand hand) {return controller.getTriggerAxis(hand);}
  public double getJoystickAxis(int axis) {return joyStick.getRawAxis(axis);}

  public class mainAuto extends SequentialCommandGroup {
    public mainAuto() {
      addCommands(

          new DriveCommand(s_Drivetrain, 0.4, 0).withTimeout(3),
          new Agipotate(s_Agipotato, ()->0.0).withTimeout(0.1),
          new TurnCommand(-0.4, s_Drivetrain).withTimeout(0.85),

          new Agipotate(s_Agipotato, ()-> 0).withTimeout(0.5),

          new OuttakePowercells(s_Outtake).withTimeout(1),
          new Agipotate(s_Agipotato, () -> 0).withTimeout(2),//Janky Wait
          new Agipotate(s_Agipotato, () -> -1.0).withTimeout(2), 
          new OuttakePowercells(s_Outtake).withTimeout(1),
          new IntakeOuttake(s_Intake,IntakeConstants.SPEED).withTimeout(0.05),
          new IntakePowercells(s_Intake,IntakeConstants.SPEED).withTimeout(3),
          new Agipotate(s_Agipotato, () -> -1.0).withTimeout(2),
          new OuttakePowercells(s_Outtake).withTimeout(2)
      );
    }
  }
  public class JustShoot extends SequentialCommandGroup {
    public JustShoot() {
      addCommands(

          new OuttakePowercells(s_Outtake).withTimeout(1),
          new Agipotate(s_Agipotato, () -> 0).withTimeout(2),//Janky Wait
          new Agipotate(s_Agipotato, () -> -1.0).withTimeout(2),
          new Agipotate(s_Agipotato, () -> 0).withTimeout(1),
          new OuttakePowercells(s_Outtake).withTimeout(1),
          new IntakeOuttake(s_Intake,IntakeConstants.SPEED).withTimeout(0.05),
          new IntakePowercells(s_Intake, IntakeConstants.SPEED).withTimeout(3),
          new Agipotate(s_Agipotato, () -> -1.0).withTimeout(2),
          new OuttakePowercells(s_Outtake).withTimeout(2)

      );
    }
  }

  public Command getAutonomousCommand() {
    return new mainAuto();
  }
}
