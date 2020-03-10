/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnCommand extends CommandBase {

  Drivetrain s_drivetrain;
  Double turnspeed;

  /**
   * This command runs the Drivetrain and should be used to turn the robot on its z axis without x or y movement
   *
   * @param drivetrain the Drivetrain Subsystem
   * @param turnspeed speed the desired rotation speed of the robot
   * @see Drivetrain
   * 
   * @author Andrew Card
   */

  public TurnCommand(Double turnspeed,Drivetrain s_drivetrain) {
    
    this.s_drivetrain = s_drivetrain;
    this.turnspeed = turnspeed;

  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    s_drivetrain.autoDrive(turnspeed, -turnspeed);

  }

  @Override
  public void end(boolean interrupted) {
    s_drivetrain.voltDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
