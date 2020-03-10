/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ServoConstants;
import frc.robot.subsystems.Camera_Intake;

public class IntakeServo extends CommandBase {

  Camera_Intake servo;
  /**
   * This command changes the Intake Camera Servo position when the command is either initialized or ended
   *
   * @param Camera_Intake the Camera_intake Subsystem
   * @see Camera_Intake
   * 
   * @author Andrew Card
   */
  public IntakeServo(Camera_Intake servo) {
    this.servo = servo;
    addRequirements(servo);
  }

  @Override
  public void initialize() {
    servo.setIntakeCameraServo(ServoConstants.LIFT_ANGLE);
  }

  @Override
  public void execute() {
    
  }

  @Override
  public void end(boolean interrupted) {
    servo.setIntakeCameraServo(ServoConstants.INTAKE_ANGLE);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
