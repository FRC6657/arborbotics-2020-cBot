/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends CommandBase {

  Drivetrain drivetrain;
  double speed;
  double rotation;

  /**
   * This command runs the Drivetrain when the command is executing | Not for driver control use
   *
   * @param drivetrain the Drivetrain Subsystem
   * @param speed the desired forward speed of the robot
   * @param rotation the desired turning speed of the robot
   * @see Drivetrain
   * 
   * @author Andrew Card
   */
  public DriveCommand(Drivetrain drivetrain, double speed, double rotation) {
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.rotation = rotation;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    drivetrain.comboDrive(speed, rotation);
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.comboDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
