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
import frc.robot.subsystems.Lift;

public class LiftDrive extends CommandBase {
  
  private final Lift lift;
  private final DoubleSupplier speed;

  public LiftDrive(Lift lift, DoubleSupplier speed) {
    
    this.lift = lift;
    this.speed = speed;

    addRequirements(lift);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lift.LiftMove(speed.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lift.LiftMove(0);  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
