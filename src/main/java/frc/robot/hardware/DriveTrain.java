/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.Constants.Doubles;
import frc.robot.Constants.IDs;
import frc.robot.Constants.PID;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

public class DriveTrain extends Subsystem implements PIDOutput{

  //private WPI_TalonSRX motorFL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  //private WPI_TalonSRX motorFR = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  //private WPI_TalonSRX motorBL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  //private WPI_TalonSRX motorBR = new WPI_TalonSRX(IDs.frontLeftMotor.value);

  //public WPI_TalonSRX outL = new WPI_TalonSRX(2);
  //public WPI_TalonSRX outR = new WPI_TalonSRX(1);

  //public final PIDController turnController;
  //AHRS navX;


  private double lSumOfError = 0;
  private double rSumOfError = 0;
  private double lLastError = 0;
  private double rLastError = 0;

  public double time = 0;

  public DriveTrain(){

    //motorBL.follow(motorFL);
    //motorBR.follow(motorFR);

    //navX = new AHRS(SPI.Port.kMXP);

    //turnController = new PIDController(PID.TkP,PID.TkI,PID.TkD, navX, this);

    //turnController.setInputRange(-180.0f,180.0f);
    //turnController.setOutputRange(-0.45, 0.45);
    //turnController.setAbsoluteTolerance(2.0f);
    //turnController.setContinuous(true);
    
  }

  //public void driveLeft(double speed){//motorFL.set(speed);}
  //public void driveRight(double speed){//motorFR.set(-speed);}

  public void Drive(double leftSpeed, double rightSpeed){

    //motorFL.set(leftSpeed);
    //motorFR.set(-rightSpeed);

  }

  public void teleDrive(){

    //if(Robot.controllers.getJoyAxis(1) > 0.1){outL.set(Robot.controllers.getJoyAxis(1)); outR.set(-Robot.controllers.getJoyAxis(1));}
    //if(Robot.controllers.getJoyAxis(1) < 0.1){outL.set(-Robot.controllers.getJoyAxis(1)); outR.set(Robot.controllers.getJoyAxis(1));}


    /*
    if((Robot.controllers.getJoyAxis(1) > Doubles.driveDeadband || Robot.controllers.getJoyAxis(1) < -Doubles.driveDeadband) || (Robot.controllers.getJoyAxis(3) > Doubles.turnDeadband || Robot.controllers.getJoyAxis(3) < -Doubles.turnDeadband)){

      
      double drive = -Robot.controllers.getJoyAxis(1) * Doubles.driveModifier;
      double turn = Robot.controllers.getJoyAxis(3) * Doubles.turnModifier;

      if(!(Robot.controllers.getJoyAxis(1) > Doubles.driveDeadband) || !(Robot.controllers.getJoyAxis(1) < -Doubles.driveDeadband)){drive = 0;}
      if((Robot.controllers.getJoyAxis(3) > Doubles.driveDeadband) || (Robot.controllers.getJoyAxis(3) < -Doubles.driveDeadband)){turn = 0;}
    
      double leftPower = drive + turn;
      double rightPower = drive - turn;

      Drive(leftPower, rightPower);
*/
    }
  public void PIDDrive(double setpoint){
/*
    double leftEncoderPosition = Robot.sensors.getLeftEncoderValue();
    double rightEncoderPosition = Robot.sensors.getRightEncoderValue();

    double time = Timer.getFPGATimestamp();

    if(Robot.controllers.getJoyButton(1)){setpoint = 6;}
    else if(Robot.controllers.getJoyButton(2)){setpoint = 0;}

    double lError = setpoint - leftEncoderPosition;
    double rError = setpoint - rightEncoderPosition;

    double dt = Timer.getFPGATimestamp() - time;

    if(Math.abs(lError) < PID.stopRange){lSumOfError += lError * dt;}
    if(Math.abs(rError) < PID.stopRange){rSumOfError += rError * dt;}
    
    lSumOfError += lError * dt;
    rSumOfError += rError * dt;

    double lErrorRate = (lError - lLastError) / dt;
    double rErrorRate = (rError - rLastError) / dt;

    double leftMotorOutput = PID.LkP * lError + PID.LkI * lSumOfError + PID.LkD * lErrorRate;
    double rightMotorOutput = PID.RkP * rError + PID.RkI * rSumOfError + PID.RkD * rErrorRate;

    Drive(leftMotorOutput, rightMotorOutput);

    time = Timer.getFPGATimestamp();
    
    lLastError = lError;
    rLastError = rError;
    */

  }
  public void PIDTurnAngle(double angle){

    //navX.reset();
    //turnController.reset();
    //turnController.setPID(PID.TkP,PID.TkI,PID.TkD);
    //turnController.setSetpoint(angle);
    //turnController.enable();

  }
  public void PIDTurnToAngle(double angle){

    //turnController.reset();
    //turnController.setPID(PID.TkP,PID.TkI,PID.TkD);
    //turnController.setSetpoint(angle);
    //turnController.enable();

  }

  @Override
  public void initDefaultCommand() {}

  @Override
  public void pidWrite(double output) {

    //Drive(output,output);

  }
}
