/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants.IDs;

/**
 * Add your docs here.
 */
public class Chicken3 extends Subsystem {
  
  private WPI_TalonSRX outL = new WPI_TalonSRX(IDs.outtakeL.value);//Declares left outtake motor
  private WPI_TalonSRX outR = new WPI_TalonSRX(IDs.outtakeR.value);//Declares right outtake motor

  private Servo gateServo = new Servo(0);//Declares the servo used to stop the PowerCells from getting into the wheels before we want them to

  public void outtakeOut(double speed){
    outL.set(-speed);
    outR.set(-speed);
    gateServo.setAngle(90);
  }
  public void outtakeStop(){
    outL.set(0);
    outR.set(0);
    gateServo.setAngle(140);
  }
  @Override
  public void initDefaultCommand() {}
}
