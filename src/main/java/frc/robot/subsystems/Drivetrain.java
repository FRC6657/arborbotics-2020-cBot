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

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  private final WPI_TalonSRX frontLeftMotor;
  private final WPI_VictorSPX backLeftMotor;
  private final WPI_TalonSRX frontRightMotor;
  private final WPI_VictorSPX backRightMotor;

  private int reverse;

  public Drivetrain() {

    frontLeftMotor = new WPI_TalonSRX(1);
    frontRightMotor = new WPI_TalonSRX(3);
    backLeftMotor = new WPI_VictorSPX(2);
    backRightMotor = new WPI_VictorSPX(4);

    frontLeftMotor.setNeutralMode(NeutralMode.Coast);
    backLeftMotor.setNeutralMode(NeutralMode.Coast);
    frontRightMotor.setNeutralMode(NeutralMode.Coast);
    backRightMotor.setNeutralMode(NeutralMode.Coast);

    reverse = 1;

  }

  public void Drive(double xSpeed, double zRotation) {

    double leftPower = xSpeed + zRotation;
    double rightPower = -(xSpeed - zRotation);

    frontLeftMotor.set(reverse * leftPower);
    backLeftMotor.set(reverse * leftPower);
    frontRightMotor.set(reverse * (rightPower + 0.1));
    backRightMotor.set(reverse * (rightPower + 0.1));

  }
  public void BadDrive(double left, double right){

    frontLeftMotor.set(left);
    frontRightMotor.set(-right);
    backLeftMotor.set(left);
    backRightMotor.set(-right);

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
