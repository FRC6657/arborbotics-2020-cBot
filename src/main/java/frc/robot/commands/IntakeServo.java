/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Camera_Intake;

public class IntakeServo extends CommandBase {

  Camera_Intake servo;

  public IntakeServo(Camera_Intake servo) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.servo = servo;
    addRequirements(servo);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    servo.setIntakeCameraServo(Constants.lift_servo_pos);
    System.out.println("Fire Pos");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    servo.setIntakeCameraServo(Constants.intake_servo_pos);
    System.out.println("Line Pos");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
