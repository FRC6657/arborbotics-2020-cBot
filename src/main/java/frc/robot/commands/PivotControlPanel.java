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

  /**
   * This pivots the control panel mechanism when the command is executing
   *
   * @param CP the ControlPanel Subsystem
   * @param speed the desired speed to run the pivot motor at
   * @see ControlPanel
   * 
   * @author Andrew Card
   */

  public PivotControlPanel(ControlPanel CP, double speed) {

    this.CP = CP;
    this.speed = speed;

    addRequirements(CP);
    
  }

  @Override
  public void execute() {

    CP.pivot(speed);

  }

  @Override
  public void end(boolean interrupted) {
    CP.pivot(0);
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
