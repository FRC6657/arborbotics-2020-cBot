/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase {

  private WPI_TalonSRX CPivot;
  private WPI_TalonSRX CSpin;

  public ControlPanel() {
    if (RobotBase.isReal()) {
      CPivot = new WPI_TalonSRX(10);
      CSpin = new WPI_TalonSRX(11);

      CPivot.setNeutralMode(NeutralMode.Brake);
      CSpin.setNeutralMode(NeutralMode.Brake);
    }
  }

  public void spin(double speed) {

    CSpin.set(speed);

  }

  public void pivot(double speed) {

    CPivot.set(CPivot.getSupplyCurrent());

  }

  @Override
  public void periodic() {
  }
}
