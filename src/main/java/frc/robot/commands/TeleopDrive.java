/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TeleopDrive extends CommandBase {
  
  private final Drivetrain drive;
  private final DoubleSupplier xSpeed;
  private final DoubleSupplier rotation;

  public TeleopDrive(Drivetrain drive, DoubleSupplier xSpeed, DoubleSupplier rotation) {
    
    this.drive = drive;
    this.xSpeed = xSpeed;
    this.rotation = rotation;

    addRequirements(drive);
  }

// Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.Drive(xSpeed.getAsDouble(), rotation.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.Drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
