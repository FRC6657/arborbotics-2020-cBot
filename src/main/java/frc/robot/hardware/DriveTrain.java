/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.Constants.Doubles;
import frc.robot.Constants.IDs;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends Subsystem {

  private WPI_TalonSRX motorFL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  private WPI_TalonSRX motorFR = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  private WPI_TalonSRX motorBL = new WPI_TalonSRX(IDs.frontLeftMotor.value);
  private WPI_TalonSRX motorBR = new WPI_TalonSRX(IDs.frontLeftMotor.value);

  public DriveTrain(){

    motorBL.follow(motorFL);
    motorBR.follow(motorFR);
    
  }

  public void driveLeft(double speed){motorFL.set(speed);}
  public void driveRight(double speed){motorFR.set(-speed);}

  public void Drive(double leftSpeed, double rightSpeed){

    motorFL.set(leftSpeed);
    motorFR.set(-rightSpeed);

  }

  public void teleDrive(){

    if((Robot.controllers.getJoyAxis(1) > Doubles.driveDeadband || Robot.controllers.getJoyAxis(1) < -Doubles.driveDeadband) || (Robot.controllers.getJoyAxis(3) > Doubles.turnDeadband || Robot.controllers.getJoyAxis(3) < -Doubles.turnDeadband)){

      double drive = -Robot.controllers.getJoyAxis(1) * Doubles.driveModifier;
      double turn = Robot.controllers.getJoyAxis(3) * Doubles.turnModifier;

      if(!(Robot.controllers.getJoyAxis(1) > Doubles.driveDeadband) || !(Robot.controllers.getJoyAxis(1) < -Doubles.driveDeadband)){drive = 0;}
      if((Robot.controllers.getJoyAxis(3) > Doubles.driveDeadband) || (Robot.controllers.getJoyAxis(3) < -Doubles.driveDeadband)){turn = 0;}
    
      double leftPower = drive + turn;
      double rightPower = drive - turn;

      Drive(leftPower, rightPower);

    }
  }

  @Override
  public void initDefaultCommand() {}
}
