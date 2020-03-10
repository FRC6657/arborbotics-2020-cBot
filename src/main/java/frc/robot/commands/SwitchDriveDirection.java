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

  /**
   * This switches the direction of forward on the robot by reversing the motor power
   *
   * @param s_drivetrian the Drivetrain Subsystem
   * @see Drivetrain
   * 
   * @author Andrew Card
   */

  public SwitchDriveDirection(Drivetrain s_drivetrain) {
    this.s_drivetrain = s_drivetrain;
    addRequirements(s_drivetrain);
  }

  @Override
  public void initialize() {
    s_drivetrain.switchReverse();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
