/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.ArborLib;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Servo;

/**
 * This can be used to drive motor controllers and set servo positions.
 */
public class MotorControl {

    public static void runTalonSRX(WPI_TalonSRX MotorController, double speed){MotorController.set(speed);}
    public void runVictorSPX(WPI_VictorSPX MotorController, double speed){MotorController.set(speed);}
    public void setServoAngle(Servo servo, double angle){servo.setAngle(angle);}

}
