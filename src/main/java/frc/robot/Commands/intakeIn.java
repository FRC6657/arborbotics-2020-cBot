package frc.robot.Commands;

import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants.Doubles;

public class intakeIn extends Command {
  
  public intakeIn() {
    requires(Robot.chicken1);
    requires(Robot.chicken2);
  }

  @Override
  protected void execute() {
    Robot.chicken1.Spin(Doubles.intakeSpeed);
    Robot.chicken2.whipOn(-Doubles.whipSpeed);
  }

  @Override
	protected void end() {
    Robot.chicken1.spinStop();
    Robot.chicken2.whipOff();
  }
  
  @Override
  protected boolean isFinished() {
    return false;
  }
}