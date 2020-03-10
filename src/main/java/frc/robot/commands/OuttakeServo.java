/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ServoConstants;
import frc.robot.subsystems.Camera_Outtake;

public class OuttakeServo extends CommandBase {

  Camera_Outtake servo;

  /**
   * This command changes the Outtake Camera Servo position when the command is either initialized or ended
   *
   * @param Camera_Outtake the Camera_intake Subsystem
   * @see Camera_Intake
   * 
   * @author Andrew Card
   */

  public OuttakeServo(Camera_Outtake servo) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.servo = servo;
    addRequirements(servo);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    servo.setOuttakeCameraServo(ServoConstants.FIRE_ANGLE);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    servo.setOuttakeCameraServo(ServoConstants.LINE_ANGLE);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
