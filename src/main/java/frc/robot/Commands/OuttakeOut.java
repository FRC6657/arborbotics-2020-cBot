package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class outtakeOut extends Command {
  
  public outtakeOut() {
    requires(Robot.chicken3);
  }

  @Override
  protected void execute() {
    Robot.chicken3.outtakeOut(0);
  }

  @Override
	protected void end() {
		Robot.chicken3.outtakeStop();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}