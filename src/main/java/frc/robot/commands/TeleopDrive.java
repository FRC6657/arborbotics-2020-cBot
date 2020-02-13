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
  private final double xSpeed;
  private final double rotation;
  private final boolean isQuickTurn;

  public TeleopDrive(Drivetrain drive, double xSpeed, double rotation, boolean isQuickTurn) {
    
    this.drive = drive;
    this.xSpeed = xSpeed;
    this.rotation = rotation;
    this.isQuickTurn = isQuickTurn;

    System.out.println("Command Speed: " + xSpeed);
    System.out.println("Command Rotation : " + rotation);

    addRequirements(drive);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //drive.CDrive(xSpeed, rotation, isQuickTurn);
    System.out.println("Speed: " + xSpeed);
    System.out.println("Rotation : " + rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.CDrive(0, 0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
