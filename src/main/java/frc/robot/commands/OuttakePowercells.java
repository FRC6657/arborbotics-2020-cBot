/**
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants.OuttakeConstants;
import frc.robot.Constants.ServoConstants;
import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OuttakePowercells extends CommandBase {

  private final Outtake outtakePowercells;

  /**
   * This command runs the Outtake when the command is executing
   * <p>
   * This command raises the Hopper Gate when Initialized, and Lowers it when Ended
   *
   * @param Outtake the Outtake Subsystem
   * @see Outtake
   * 
   * @author Andrew Card
   */

  public OuttakePowercells(Outtake outtakePowercells) {

    this.outtakePowercells = outtakePowercells;

    addRequirements(outtakePowercells);

  }
  @Override
  public void initialize() {

    outtakePowercells.setServoAngle(ServoConstants.GATE_UP_ANGLE);

  }

  @Override
  public void execute() {

    outtakePowercells.outtakeOut(OuttakeConstants.SPEED);

  }

  @Override
  public void end(boolean interrupted) {
    outtakePowercells.outtakeStop();

    outtakePowercells.setServoAngle(ServoConstants.GATE_DOWN_ANGLE);

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
