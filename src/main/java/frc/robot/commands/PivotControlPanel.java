/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class PivotControlPanel extends CommandBase {

  private final ControlPanel CP;
  private final double speed;

  public PivotControlPanel(ControlPanel CP, double speed) {

    this.CP = CP;
    this.speed = speed;

    addRequirements(CP);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    CP.pivot(speed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    CP.pivot(0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
