/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Agipotato;

public class Agipotate extends CommandBase {

  private final Agipotato Agipotate;
  private final DoubleSupplier Speed;

  public Agipotate(Agipotato Agipotate, DoubleSupplier Speed) {

    this.Agipotate = Agipotate;
    this.Speed = Speed;

    addRequirements(Agipotate);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Agipotate.Agipotate(Speed.getAsDouble());
    System.out.println("here");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Agipotate.Agipotate(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}