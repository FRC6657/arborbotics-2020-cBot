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

  public DriveTrain(){
    motorBL.follow(motorFL, FollowerType.AuxOutput1);
    motorBR.follow(motorFR, FollowerType.AuxOutput1);
  }


  @Override
  public void initDefaultCommand() {

    super.setDefaultCommand(new Driver_Controls());

  }
}
