/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.fasterxml.jackson.annotation.JsonInclude.Value;
import com.fasterxml.jackson.core.StreamWriteFeature;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.*;
import frc.robot.hardware.*;

public class Robot extends TimedRobot {
  
  //Subsystrem Declarations
  public static Sensors sensors = new Sensors();
  public static DriveTrain driveTrain = new DriveTrain();
  public static Chicken3 chicken3 = new Chicken3();
  public static Chicken1 chicken1 = new Chicken1();
  public static Chicken2 chicken2 = new Chicken2();
  public static Lifty lifty = new Lifty();
  public static Controllers controllers = new Controllers();
  public static Utilities utilities = new Utilities();

  public static int direction = 1; //1 = forward | -1 = reversed

  //final double LkP = PID.LkP;
  //final double LkI = PID.LkI;
  //final double LkD = PID.LkD;
  //final double RkP = PID.RkP;
  //final double RkI = PID.RkI;
  //final double RkD = PID.RkD;

  SendableChooser<String> driverProfileChooser = new SendableChooser<>();
  

  @Override
  public void robotInit() {

    //SmartDashboard.putNumber("Left Encoder Value:", sensors.getLeftEncoderValue());
    //SmartDashboard.putNumber("Right Encoder Value:", sensors.getRightEncoderValue());

    Robot.controllers = new Controllers();

    driverProfileChooser.setDefaultOption("Dual Driver", "Double");
    driverProfileChooser.addOption("Single Stick", "Single");
    driverProfileChooser.addOption("Andrew's Drive", "Andrew");
    
    SmartDashboard.putData("Driver Profile",driverProfileChooser);
    
  }

  @Override
  public void autonomousInit() {
    sensors.resetAngle();//Resets navX Angle
    //sensors.ResetEncoders();
    //driveLocomotive.time = 0;
  }

  @Override
  public void autonomousPeriodic() {

    
  }

  @Override
  public void teleopInit() {
    sensors.resetAngle();//Resets navX Angle
    controllers.DriverProfile = driverProfileChooser.getSelected();
    SmartDashboard.putString("Selected Profile", driverProfileChooser.getSelected());
  }
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }


  @Override
  public void robotPeriodic() {

    Shuffleboard.getTab("SmartDashboard");//Creates new Shuffleboard Tab
    SmartDashboard.putNumber("Angle",Robot.sensors.getAngle()); //Puts the navX Z rotation angle onto the Shuffleboard Tab 'SmartDashboard'
    SmartDashboard.putNumber("LBumper", Robot.controllers.getControllerAxis(3));
    SmartDashboard.putNumber("RBumper", Robot.controllers.getControllerAxis(2));

  }
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
