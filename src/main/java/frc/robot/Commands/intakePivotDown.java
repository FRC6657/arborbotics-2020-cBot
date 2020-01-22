package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants.Doubles;

public class intakePivotDown extends Command {
  
  public intakePivotDown() {
    requires(Robot.chicken1);
  }

  @Override
  protected void execute() {
    Robot.chicken1.Pivot(-Doubles.intakePivotUpSpeed);
  }

  @Override
  protected void end() {
    Robot.chicken1.pivotStop();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}