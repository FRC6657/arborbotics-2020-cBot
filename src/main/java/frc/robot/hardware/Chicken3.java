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

  public void Out(double speed){outL.set(speed); outR.set(speed);}//Shoots the Ball
  public void In(double speed){outL.set(-speed); outR.set(-speed);}//Un-Shoots the ball(Basically Useless)
  public void Stop(){outL.set(0);outR.set(0);}//Stops the outtake from spinning(Basically Useless)
  public void OpenGate(){gateServo.set(0.5);}//Opens the gate to allow Powercells to be shot
  public void CloseGate(){gateServo.set(0);}//Closes the gate to allow Powercells to be stored properly

  @Override
  public void initDefaultCommand() {
  }
}
