package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants.Doubles;

public class outtakeOut extends Command {
  
  public outtakeOut() {
    requires(Robot.chicken3);
    requires(Robot.chicken2);
  }

  @Override
  protected void execute() {
    Robot.chicken3.outtakeOut(Doubles.outtakeSpeed);
    Robot.chicken2.whipOn(Doubles.whipSpeed);
  }

  @Override
	protected void end() {
    Robot.chicken3.outtakeStop();
    Robot.chicken2.whipOff();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}