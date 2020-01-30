/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.ArborLib.Control;
import frc.robot.Constants.ControllerBinds;
import frc.robot.Constants.Doubles;

public class Driver_Controls extends Command {
  public Driver_Controls() {

    super.requires(Robot.driveTrain);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    if(Robot.selectedProfile == "Single"){Control.StickDrive(Robot.controllers.getJoyAxis(ControllerBinds.JDriveAxis.value),Robot.controllers.getJoyAxis(ControllerBinds.JTurnAxis.value),Robot.driveTrain.motorFL,Robot.driveTrain.motorFR,Doubles.driveDeadbandMax,Doubles.driveDeadbandMin,Doubles.turnDeadbandMax,Doubles.turnDeadbandMin,Doubles.maxSpeed);}
    else if(Robot.selectedProfile == "Double"){Control.StickDrive(Robot.controllers.getJoyAxis(ControllerBinds.JDriveAxis.value),Robot.controllers.getJoyAxis(ControllerBinds.JTurnAxis.value),Robot.driveTrain.motorFL,Robot.driveTrain.motorFR,Doubles.driveDeadbandMax,Doubles.driveDeadbandMin,Doubles.turnDeadbandMax,Doubles.turnDeadbandMin,Doubles.maxSpeed);}
    else if(Robot.selectedProfile == "Andrew"){Control.AndrewDrive(Robot.controllers.getControllerAxis(ControllerBinds.AGasAxis.value),Robot.controllers.getControllerAxis(ControllerBinds.ABrakeAxis.value),Robot.controllers.getControllerAxis(ControllerBinds.ATurnAxis.value),Robot.driveTrain.motorFL,Robot.driveTrain.motorFR,Doubles.ADriveDeadbandMax,Doubles.ADriveDeadbandMin,Doubles.ATurnDeadbandMax,Doubles.ATurnDeadbandMin,Doubles.maxSpeed);}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //Robot.driveTrain.Drive(0, 0);
  }
}
