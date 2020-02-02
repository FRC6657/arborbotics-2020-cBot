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
  private final DoubleSupplier speed;
  private final DoubleSupplier rotation;
  private final BooleanSupplier isQuickTurn;

  public TeleopDrive(Drivetrain drive, DoubleSupplier speed, DoubleSupplier rotation, BooleanSupplier isQuickTurn) {
    
    this.drive = drive;
    this.speed = speed;
    this.rotation = rotation;
    this.isQuickTurn = isQuickTurn;

    addRequirements(drive);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.drive(speed.getAsDouble(),rotation.getAsDouble(), isQuickTurn.getAsBoolean());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.drive(0, 0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
