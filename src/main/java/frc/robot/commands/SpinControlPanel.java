/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanel;

public class SpinControlPanel extends CommandBase {

  private final ControlPanel CP;
  private final double speed;

  /**
   * This spins the control panel when the command is executing
   *
   * @param CP the ControlPanel Subsystem
   * @param speed the desired speed to run the spinner motor at
   * @see ControlPanel
   * 
   * @author Andrew Card
   */

  public SpinControlPanel(ControlPanel CP, double speed) {

    this.CP = CP;
    this.speed = speed;

    addRequirements(CP);
    
  }

  @Override
  public void execute() {

    CP.spin(speed);

  }

  @Override
  public void end(boolean interrupted) {
    CP.spin(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
