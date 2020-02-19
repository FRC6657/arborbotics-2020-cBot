/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanel extends SubsystemBase {

  private WPI_TalonSRX CPivot;
  private WPI_TalonSRX CSpin;
  private ColorSensorV3 colorSensor;

  public ControlPanel() {

    CPivot = new WPI_TalonSRX(10);
    CSpin = new WPI_TalonSRX(11);
    colorSensor = new ColorSensorV3(I2C.Port.kOnboard);

    CPivot.setNeutralMode(NeutralMode.Brake);
    CSpin.setNeutralMode(NeutralMode.Brake);

  }

  public void Spin(double speed){

    CSpin.set(speed);

  }
  public void Pivot(double speed){

    CPivot.set(speed);

  }

  @Override
  public void periodic() {
    
    double IR = colorSensor.getIR();

    Color detectedColor = colorSensor.getColor();

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);

    int proximity = colorSensor.getProximity();

    SmartDashboard.putNumber("Proximity", proximity);

  }
}
