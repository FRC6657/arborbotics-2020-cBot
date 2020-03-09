/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ControlPanelConstants;
import frc.robot.subsystems.ColorThings;
import frc.robot.subsystems.ControlPanel;

public class SpinTillColor extends CommandBase {

  ControlPanel s_controlpanel;
  ColorThings s_colorthings;
  int loops = 0;

  public SpinTillColor(ControlPanel s_controlpanel, ColorThings s_colorthings) {
    this.s_colorthings = s_colorthings;
    this.s_controlpanel = s_controlpanel;

    addRequirements(s_colorthings, s_controlpanel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    s_controlpanel.spin(ControlPanelConstants.ROTATE_SPEED);

    if(s_colorthings.getColorString().equals(s_colorthings.getMatchData())){isFinished();}

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_controlpanel.spin(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
