/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class SwitchDriveDirection extends CommandBase {

  private Drivetrain s_drivetrain;

  public SwitchDriveDirection(Drivetrain s_drivetrain) {
    this.s_drivetrain=s_drivetrain;
    addRequirements(s_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_drivetrain.switchReverse();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
