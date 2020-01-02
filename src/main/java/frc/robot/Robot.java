/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.hal.sim.RelaySim;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants.*;
import frc.robot.hardware.*;

public class Robot extends TimedRobot {

  public static Encoders encoders = new Encoders();
  public static DriveTrain drivetrain = new DriveTrain();
  public static Controllers controllers = new Controllers();

  final double LkP = PID.LkP;
  final double LkI = PID.LkI;
  final double LkD = PID.LkD;
  final double RkP = PID.RkP;
  final double RkI = PID.RkI;
  final double RkD = PID.RkD;

  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
    encoders.Reset();
    lSumOfError = 0;
    rSumOfError = 0;
    lLastError = 0;
    rLastError = 0;
    time = 0;
  }

  double setpoint = 0;
  double lSumOfError = 0;
  double rSumOfError = 0;
  double lLastError = 0;
  double rLastError = 0;

  double time = Timer.getFPGATimestamp();

  @Override
  public void autonomousPeriodic() {

    double leftEncoderPosition = encoders.getLeftEncoderValue();
    double rightEncoderPosition = encoders.getRightEncoderValue();

    if(controllers.getButton(1)){setpoint = 6;}
    else if(controllers.getButton(2)){setpoint = 0;}

    double lError = setpoint - leftEncoderPosition;
    double rError = setpoint - rightEncoderPosition;

    double dt = Timer.getFPGATimestamp() - time;

    if(Math.abs(lError) < PID.stopRange){lSumOfError += lError * dt;}
    if(Math.abs(rError) < PID.stopRange){rSumOfError += rError * dt;}
    
    lSumOfError += lError * dt;
    rSumOfError += rError * dt;

    double lErrorRate = (lError - lLastError) / dt;
    double rErrorRate = (rError - rLastError) / dt;

    double leftMotorOutput = LkP * lError + LkI * lSumOfError + LkD * lErrorRate;
    double rightMotorOutput = RkP * rError + RkI * rSumOfError + RkD * rErrorRate;

    drivetrain.Drive(leftMotorOutput, rightMotorOutput);

    time = Timer.getFPGATimestamp();
    
    lLastError = lError;
    rLastError = rError;

  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
