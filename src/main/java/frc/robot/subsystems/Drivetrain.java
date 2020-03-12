/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX m_frontLeft;
  private WPI_VictorSPX m_backLeft;
  private WPI_TalonSRX m_frontRight;
  private WPI_VictorSPX m_backRight;

  private SpeedControllerGroup m_leftmotors;
  private SpeedControllerGroup m_rightmotors;

  private Encoder m_leftEncoder;
  private Encoder m_rightEncoder;

  private boolean reverse = false;

  /**
   * 
   * Drivetrain Subsystem
   * 
   */
  public Drivetrain() {

      //motor declaration
      m_frontLeft = new WPI_TalonSRX(DriveConstants.FRONT_LEFT_ID);
      m_frontRight = new WPI_TalonSRX(DriveConstants.FRONT_RIGHT_ID);
      m_backLeft = new WPI_VictorSPX(DriveConstants.BACK_LEFT_ID);
      m_backRight = new WPI_VictorSPX(DriveConstants.BACK_RIGHT_ID);

      m_frontLeft.setNeutralMode(NeutralMode.Coast);
      m_backLeft.setNeutralMode(NeutralMode.Coast);
      m_frontRight.setNeutralMode(NeutralMode.Coast);
      m_backRight.setNeutralMode(NeutralMode.Coast);

      m_leftmotors = new SpeedControllerGroup(m_frontLeft, m_backLeft);
      m_rightmotors = new SpeedControllerGroup(m_frontRight, m_backRight);

      m_leftEncoder = new Encoder(0,1);
      m_rightEncoder = new Encoder(2,3);
      
      Shuffleboard.getTab("Drivetrain")
      .add("LeftMotor", m_frontLeft.getMotorOutputPercent())
        .withPosition(0, 0)
        .withWidget(BuiltInWidgets.kDial)
        .withSize(2, 1);

    Shuffleboard.getTab("Drivetrain")
      .add("RightMotor", m_frontRight.getMotorOutputPercent())
        .withPosition(2, 0)
        .withWidget(BuiltInWidgets.kDial)
        .withSize(2, 1);
    
    Shuffleboard.getTab("Drivetrain")
      .add("Reverse", getReverse())
        .withPosition(0, 1)
        .withWidget(BuiltInWidgets.kBooleanBox)
        .withSize(4, 0);
    
  }
  //Drive with both forward and sideways power
  public void comboDrive(double xSpeed, double zRotation) {

    double leftPower = xSpeed + zRotation;
    double rightPower = -(xSpeed - zRotation);

    if(reverse){
      m_leftmotors.set(-leftPower);
      m_rightmotors.set(-rightPower);
    }
    if(!reverse){
      m_leftmotors.set(leftPower);
      m_rightmotors.set(rightPower);
    }
  }

  //Drive with only motor power
  public void pureDrive(double left, double right) {

    m_leftmotors.set(left);
    m_rightmotors.set(-right);

  }

  //drive with drift compensation
  public void autoDrive(double xSpeed, double zRotation){

    double leftPower = xSpeed + zRotation;
    double rightPower = -(xSpeed - zRotation);

    m_leftmotors.set(leftPower);
    m_rightmotors.set(rightPower + DriveConstants.DRIFT_AJUST);

  }
  //drive with volts
  public void voltDrive(double left_volts, double right_volts) {

    m_leftmotors.setVoltage(left_volts);
    m_rightmotors.setVoltage(right_volts);

  }
  //switch robot direction
  public void switchReverse() {
    reverse = !reverse;
  }
  //get direction
  public boolean getReverse() {
    return reverse;
  }

  @Override
  public void periodic() {

    Shuffleboard.update();

    SmartDashboard.putNumber("Left Encoder: ", m_leftEncoder.getDistance());
    SmartDashboard.putNumber("Right Encoder: ", m_rightEncoder.getDistance());

  }
}
