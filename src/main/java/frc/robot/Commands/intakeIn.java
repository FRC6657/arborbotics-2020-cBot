package frc.robot.Commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants.Doubles;

public class intakeIn extends Command {
  
  public intakeIn() {
    requires(Robot.chicken1);
  }

  @Override
  protected void execute() {
    Robot.chicken1.Spin(Doubles.intakeSpeed);
  }

  @Override
	protected void end() {
		Robot.chicken1.spinStop();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}