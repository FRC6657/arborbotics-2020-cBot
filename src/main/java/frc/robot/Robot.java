/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.StreamWriteFeature;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.intakeIn;
import frc.robot.Commands.intakeOut;
import frc.robot.Commands.outtakeIn;
import frc.robot.Commands.outtakeOut;
import frc.robot.Constants.*;
import frc.robot.hardware.*;

public class Robot extends TimedRobot {
  
  //Subsystrem Declarations
  public static Sensors sensors = new Sensors();
  public static DriveTrain driveTrain = new DriveTrain();
  public static Chicken3 chicken3 = new Chicken3();
  public static Chicken1 chicken1 = new Chicken1();
  //public static Chicken2 chicken2 = new Chicken2();
  public static Lifty lifty = new Lifty();
  public static ControlPanel controlPanel = new ControlPanel();
  public static Controllers controllers = new Controllers();

  public static int direction = 1; //1 = forward | -1 = reversed
  public static String selectedProfile = "Andrew";

  @Override
  public void robotInit() {

    Robot.controllers = new Controllers();

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void robotPeriodic() {

  }

  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
