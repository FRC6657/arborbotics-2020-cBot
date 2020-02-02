/**
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OuttakePowercells extends CommandBase {

  private final Outtake outtakePowercells;

  public OuttakePowercells(Outtake outtakePowercells) {
   
    this.outtakePowercells = outtakePowercells;

    addRequirements(outtakePowercells);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    outtakePowercells.OuttakeOut(1);
    outtakePowercells.setServoAngle(135);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    outtakePowercells.OuttakeStop();
    outtakePowercells.setServoAngle(180);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
