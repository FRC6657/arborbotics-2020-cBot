/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeOuttake extends CommandBase {

  private final Intake intakeOuttake;
  private final double speed;
  public IntakeOuttake(Intake intakeOuttake,double speed) {
   
    this.intakeOuttake = intakeOuttake;
    this.speed = speed;

    addRequirements(intakeOuttake);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    intakeOuttake.intakeIn(speed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeOuttake.intakeIn(0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}