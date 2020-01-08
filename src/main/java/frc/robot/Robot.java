/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants.*;
import frc.robot.hardware.*;

public class Robot extends TimedRobot {
  
  private Controllers controllers = new Controllers();

  public WPI_TalonSRX outR = new WPI_TalonSRX(1);
  public WPI_TalonSRX outL = new WPI_TalonSRX(2);

  //final double LkP = PID.LkP;
  //final double LkI = PID.LkI;
  //final double LkD = PID.LkD;
  //final double RkP = PID.RkP;
  //final double RkI = PID.RkI;
  //final double RkD = PID.RkD;

  @Override
  public void robotInit() {

    //SmartDashboard.putNumber("Left Encoder Value:", sensors.getLeftEncoderValue());
    //SmartDashboard.putNumber("Right Encoder Value:", sensors.getRightEncoderValue());

  }

  @Override
  public void autonomousInit() {
    //sensors.ResetEncoders();
    //drivetrain.time = 0;
  }

  @Override
  public void autonomousPeriodic() {

    
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {

    if(controllers.getJoyAxis(1) > 0.1){outL.set(controllers.getJoyAxis(1)); outR.set(-controllers.getJoyAxis(1));}
    if(controllers.getJoyAxis(1) < 0.1){outL.set(-controllers.getJoyAxis(1)); outR.set(controllers.getJoyAxis(1));}


  }

  @Override
  public void robotPeriodic() {

  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
