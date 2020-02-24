/**
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OuttakePowercells extends CommandBase {

  private final Outtake outtakePowercells;

  public OuttakePowercells(Outtake outtakePowercells) {
   
    this.outtakePowercells = outtakePowercells;

    addRequirements(outtakePowercells);

  }
  @Override
  public void initialize() {
    super.initialize();
    outtakePowercells.setServoAngle(170);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    outtakePowercells.OuttakeOut(1);

    System.out.println("Outtake");

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
