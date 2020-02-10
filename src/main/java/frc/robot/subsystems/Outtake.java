/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Outtake extends SubsystemBase {

  private WPI_TalonSRX outtakeLeft;
  private WPI_TalonSRX outtakeRight;
  private Servo gate;

  public Outtake() {

    outtakeLeft = new WPI_TalonSRX(7);
    outtakeRight = new WPI_TalonSRX(8);
    gate = new Servo(0);

    outtakeLeft.setNeutralMode(NeutralMode.Coast);
    outtakeRight.setNeutralMode(NeutralMode.Coast);

  }

  public void OuttakeOut(double speed){

    outtakeLeft.set(-speed);
    outtakeRight.set(-speed);

//    gate.setAngle(135);

  }

  public void OuttakeIn(double speed){

    outtakeLeft.set(speed);
    outtakeRight.set(speed);

  }

  public void OuttakeStop(){

    outtakeLeft.set(0);
    outtakeRight.set(0);

  }
  public void setServoAngle(double angle){

    gate.setAngle(angle);

  }

  @Override
  public void periodic() {

  }
}
