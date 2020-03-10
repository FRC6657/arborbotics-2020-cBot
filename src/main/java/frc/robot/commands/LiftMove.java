/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;

public class LiftMove extends CommandBase {

  private final Lift lift;
  private final double speed;

  /**
   * This command runs the Lift when the command is executing and should be used for button based driver control
   *
   * @param lift the Lift Subsystem
   * @param speed the desired speed/power of the lift
   * @see Lift
   * 
   * @author Andrew Card
   */

  public LiftMove(Lift lift, double speed) {
  
    this.lift = lift;
    this.speed = speed;

    addRequirements(lift);

  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {



  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lift.liftMove(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lift.liftMove(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
