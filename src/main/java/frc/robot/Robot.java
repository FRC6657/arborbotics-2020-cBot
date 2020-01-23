/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.*;
import frc.robot.hardware.*;

public class Robot extends TimedRobot {
  
  //Subsystrem Declaration
  public static Controllers controllers;
  public static Sensors sensors = new Sensors();
  public static DriveTrain driveTrain = new DriveTrain();
  public static Chicken3 chicken3 = new Chicken3();
  public static Chicken1 chicken1 = new Chicken1();
  public static Pigeon1 pigeon1 = new Pigeon1();

  //public WPI_TalonSRX motorFL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  //public WPI_TalonSRX motorFR = new WPI_TalonSRX(IDs.frontRightMotor.value);
  //public VictorSPX motorBL = new VictorSPX(IDs.backLeftMotor.value);
  //public VictorSPX motorBR = new VictorSPX(IDs.backRightMotor.value);

  //public WPI_TalonSRX outR = new WPI_TalonSRX(7);
  //public WPI_TalonSRX outL = new WPI_TalonSRX(8);

  //final double LkP = PID.LkP;
  //final double LkI = PID.LkI;
  //final double LkD = PID.LkD;
  //final double RkP = PID.RkP;
  //final double RkI = PID.RkI;
  //final double RkD = PID.RkD;

  @Override
  public void robotInit() {

    //SmartDashboard.putNumber("Left Encoder Value:", sensors.getLeftEncoderValue());
    //SmartDashboard.putNumber("Right Encoder Value:", sensors.getRightEncoderValue());

    controllers = new Controllers();//Allows controller inputs

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
  }
  @Override
  public void teleopPeriodic() {
    /* This code will stay here until the correct controll code is proven to work.
    if(Robot.controllers.getJoyButton(1)){chicken3.Out(0.9);}
    if(Robot.controllers.getJoyButton(2)){chicken3.In(0.9);}
    if(Robot.controllers.getJoyButton(5)){chicken3.Stop();}
    
    if(Robot.controllers.getJoyButton(6)){chicken1.Spin(0.8);}
    if(Robot.controllers.getJoyButton(4)){chicken1.Spin(-0.8);}
    if(Robot.controllers.getJoyButton(5)){chicken1.Spin(0);}

    if(Robot.controllers.getJoyButton(12)){chicken1.Pivot(0.2);}
    if(Robot.controllers.getJoyButton(11)){chicken1.Pivot(-0.2);}
    if(Robot.controllers.getJoyButton(5)){chicken1.Pivot(0);}

    if(Robot.controllers.getJoyButton(1)){servo.set(0.5);}
    if(Robot.controllers.getJoyButton(6)){servo.set(0);}
    */

  }

  @Override
  public void robotPeriodic() {

    Shuffleboard.getTab("SmartDashboard");//Creates new Shuffleboard Tab
    SmartDashboard.putNumber("Angle",Robot.sensors.getAngle()); //Puts the navX Z rotation angle onto the Shuffleboard Tab 'SmartDashboard'

  }
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
