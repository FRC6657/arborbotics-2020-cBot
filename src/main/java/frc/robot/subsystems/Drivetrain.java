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

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class Drivetrain extends SubsystemBase {

  private WPI_TalonSRX m_frontLeft;
  private WPI_VictorSPX m_backLeft;
  private WPI_TalonSRX m_frontRight;
  private WPI_VictorSPX m_backRight;

  private SpeedControllerGroup m_leftmotors;
  private SpeedControllerGroup m_rightmotors;

  private int reverse;

  public Drivetrain() {
    if (RobotBase.isReal()) {
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

      reverse = 1;
    }
  }

  public void comboDrive(double xSpeed, double zRotation) {

    double leftPower = xSpeed + zRotation;
    double rightPower = -(xSpeed - zRotation);

    m_leftmotors.set(reverse * leftPower);
    m_rightmotors.set(reverse * (rightPower + DriveConstants.DRIFT_AJUST));

  }

  public void pureDrive(double left, double right) {

    m_leftmotors.set(left);
    m_rightmotors.set(-right);

  }

  public void voltDrive(double left_volts, double right_volts) {

    m_leftmotors.setVoltage(left_volts);
    m_rightmotors.setVoltage(right_volts);

  }

  public void switchReverse() {
    reverse = -reverse;
  }

  public double getReverse() {
    return reverse;
  }

  @Override
  public void periodic() {
  }
}
