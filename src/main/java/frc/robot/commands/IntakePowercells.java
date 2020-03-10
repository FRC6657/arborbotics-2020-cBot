/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakePowercells extends CommandBase {

  private final Intake intake;
  private final double speed;

  /**
   * This command runs the Intake when the command is executing
   *
   * @param intake the Intake Subsystem
   * @param speed the desired Intake Speed
   * @see Intake
   * 
   * @author Andrew Card
   */

  public IntakePowercells(Intake intake,double speed) {
   
    this.intake = intake;
    this.speed = speed;

    addRequirements(intake);

  }

  @Override
  public void execute() {

    intake.intake(speed);

  }

  @Override
  public void end(boolean interrupted) {
    intake.intake(0);
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
