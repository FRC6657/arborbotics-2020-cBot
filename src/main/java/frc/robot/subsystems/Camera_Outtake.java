/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera_Outtake extends SubsystemBase {

  private Servo outtakeServo;

  public Camera_Outtake() {

    outtakeServo = new Servo(8);

  }

  public void setOuttakeCameraServo(double angle){
    outtakeServo.setAngle(angle);
   System.out.println("outtakeServoFunction");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
