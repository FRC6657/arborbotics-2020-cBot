/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.Commands.Driver_Controls;
import frc.robot.Constants.Doubles;
import frc.robot.Constants.IDs;
import frc.robot.Constants.PID;
import edu.wpi.first.wpilibj.SPI;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

public class DriveTrain extends Subsystem {

  public WPI_TalonSRX motorFL = new WPI_TalonSRX(IDs.frontLeftMotor.value); //Declares Front Left Motor
  public WPI_TalonSRX motorFR = new WPI_TalonSRX(IDs.frontRightMotor.value);//Declares Front Right Motor
  public WPI_VictorSPX motorBL = new WPI_VictorSPX(IDs.backLeftMotor.value);//Declares Back Left Motor
  public WPI_VictorSPX motorBR = new WPI_VictorSPX(IDs.backRightMotor.value);//Declares Back Right Motor

  /*PID Things that can be ignored for now
  private double lSumOfError = 0;
  private double rSumOfError = 0;
  private double lLastError = 0;
  private double rLastError = 0;

  public double time = 0;
*/  
  public DriveTrain(){
    motorBL.follow(motorFL, FollowerType.AuxOutput1);
    motorBR.follow(motorFR, FollowerType.AuxOutput1);
  }

  public void driveLeft(double speed){motorFL.set(speed);}//For controlling only the left side of the drivetrain
  public void driveRight(double speed){motorFR.set(-speed);}//For controlling only the right side of the drivetrain

  public void Drive(double leftSpeed, double rightSpeed){//For controlling both sides of the drivetrain at once
    motorFL.set(leftSpeed);
    motorFR.set(rightSpeed);
    motorBL.set(leftSpeed);
    motorBR.set(rightSpeed);
  }

  public void StickDrive(){//This contains the drive code for Stick Driving

    double drive = Robot.controllers.getJoyAxis(2) * Doubles.driveModifier; //Creates a variable for the intent to move on the robots y axis
    double turn = Robot.controllers.getJoyAxis(1) * Doubles.turnModifier;//Creates a variable for the intent to move on the robots z axis

    if(Robot.controllers.getJoyAxis(2) < Doubles.driveDeadband & Robot.controllers.getJoyAxis(2) > -Doubles.driveDeadband){drive = 0;}//Deadband for y axis
    if(Robot.controllers.getJoyAxis(1) < Doubles.turnDeadband & Robot.controllers.getJoyAxis(1) > -Doubles.turnDeadband){turn = 0;}//Deadband for z axis

    double leftSpeed = drive + turn; //Calculates the left drive power based on the movement intent of the driver
    double rightSpeed = drive - turn; //Calculates the right drive power based on the movement intent of the driver

    Drive(leftSpeed, -rightSpeed); //Drives the robot based on calculated drive speeds

  }

  public void AndrewDrive(){//Drive code for my personal driving style

    double maxDrive = 1;

    double rightTrigger = Robot.controllers.getControllerAxis(3);
    double leftTrigger = Robot.controllers.getControllerAxis(2);
    double leftStick = Robot.controllers.getControllerAxis(1);

    if(rightTrigger < Doubles.driveDeadband){rightTrigger = 0;}
    if(leftTrigger < Doubles.driveDeadband){leftTrigger = 0;}
    if(leftStick < Doubles.turnDeadband && leftStick > 0){leftStick = 0;}
    if(leftStick < -Doubles.turnDeadband && leftStick < 0){leftStick = 0;}

    double squaredRightTrigger = Math.pow(rightTrigger,2);
    double squaredLeftTrigger = Math.pow(leftTrigger, 2);
    double squaredLeftStick = Math.pow(leftStick, 2);

    if(rightTrigger < 0){squaredRightTrigger *= -1;}
    if(leftTrigger < 0){squaredLeftTrigger *= -1;}
    if(leftStick < 0){squaredLeftStick *= -1;}

    double drive = (squaredRightTrigger - squaredLeftTrigger) * Doubles.driveModifier; 
    double turn = squaredLeftStick * Doubles.turnModifier;

    double leftPower = drive + turn;
    double rightPower = drive - turn;

    if(leftPower > maxDrive && leftPower > 0){leftPower = maxDrive;}
    if(leftPower < -maxDrive && leftPower < 0){leftPower = -maxDrive;}

    if(rightPower > maxDrive && rightPower > 0){rightPower = maxDrive;}
    if(rightPower < -maxDrive && rightPower < 0){rightPower = -maxDrive;}

    Drive(leftPower, -rightPower); 

  }
/*
  public void PIDDrive(double setpoint){//PID Things that can be ignored for now

  
    double leftEncoderPosition = Robot.sensors.getLeftEncoderValue();
    double rightEncoderPosition = Robot.sensors.getRightEncoderValue();

    double time = Timer.getFPGATimestamp();

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
    

  }*/

  @Override
  public void initDefaultCommand() {

    super.setDefaultCommand(new Driver_Controls());

  }

  /*
  @Override
  public void pidWrite(double output) {

    //Drive(output,output);

  }
  */
}
