/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ServoConstants;

public class Camera_Intake extends SubsystemBase {

  private Servo intakeServo;

  public Camera_Intake() {
    if(RobotBase.isReal()){
      intakeServo = new Servo(ServoConstants.INTAKE_CAMERA_PWM);
    }
  }

  public void setIntakeCameraServo(double angle){
  intakeServo.setAngle(angle);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
