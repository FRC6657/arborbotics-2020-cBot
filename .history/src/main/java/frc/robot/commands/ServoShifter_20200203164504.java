/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ServoShifter extends CommandBase {
  private final Outtake outtakePowercells;
  public ServoShifter(Outtake outtakePowercells) {
    this.outtakePowercells = outtakePowercells;
    addRequirements(outtakePowercells);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    outtakePowercells.setServoAngle(10);
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