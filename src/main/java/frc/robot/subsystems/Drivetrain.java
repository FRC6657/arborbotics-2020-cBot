/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private final SpeedController frontLeftMotor;
  private final SpeedController backLeftMotor;
  private final SpeedController frontRightMotor;
  private final SpeedController backRightMotor;

  private final SpeedControllerGroup leftMotors;
  private final SpeedControllerGroup rightMotors;

  private final DifferentialDrive driveBase;

  public Drivetrain() {

    frontLeftMotor = new WPI_TalonSRX(1);
    frontRightMotor = new WPI_TalonSRX(3);
    backLeftMotor = new WPI_VictorSPX(2);
    backRightMotor = new WPI_VictorSPX(4);

    leftMotors = new SpeedControllerGroup(frontLeftMotor,backLeftMotor);
    rightMotors = new SpeedControllerGroup(frontRightMotor,backRightMotor);

    driveBase = new DifferentialDrive(leftMotors, rightMotors);
    driveBase.setRightSideInverted(true);

  }

  public void drive(double xSpeed, double zRotation, boolean isQuickTurn) {
    driveBase.curvatureDrive(xSpeed, zRotation, isQuickTurn);
  }

  @Override
  public void periodic() {

  }
}
