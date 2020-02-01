/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.ArborLib;

import java.rmi.MarshalException;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Remember what direction warrents a positive or negative value on your axis 
 * Ex. For a standard Joystick forward is negative and backward is positive. 
 * The deadPositive in this case would be the Backward Deadband and deadNegative the Forward Deadband
 */
public class Control {

    public static double applyAxisDeadband(double AxisPos, double deadPositive, double deadNegative, double axisMax, double axisMin){

        double joyStickOutput;

        if(AxisPos > deadNegative && AxisPos < deadPositive){joyStickOutput = 0;}
        else if(AxisPos > deadPositive){joyStickOutput = Scaling.scaleDouble(AxisPos, deadPositive, axisMax, 0.0, axisMax);}
        else if(AxisPos < deadNegative){joyStickOutput = Scaling.scaleDouble(AxisPos, axisMin, deadNegative, axisMin, 0.0);}
        else{joyStickOutput = AxisPos;}

        return joyStickOutput;
        
    }

    public static void StickDrive(double DriveAxisPos, double TurnAxisPos, WPI_TalonSRX leftMaster, WPI_TalonSRX rightMaster, double driveDeadMax, double driveDeadMin, double turnDeadMax, double turnDeadMin,double maxSpeed){

        double drive = applyAxisDeadband(DriveAxisPos, driveDeadMax, driveDeadMin,maxSpeed,-maxSpeed);
        double turn = applyAxisDeadband(TurnAxisPos, turnDeadMax, turnDeadMin,maxSpeed,-maxSpeed);

        MotorControl.runTalonSRX(leftMaster,(drive + turn));
        MotorControl.runTalonSRX(rightMaster, -(drive - turn));

    }

    public static void AndrewDrive(double GasAxis,double BrakeAxis, double TurnAxisPos, WPI_TalonSRX leftMaster, WPI_TalonSRX rightMaster, double driveDeadMax, double driveDeadMin, double turnDeadMax, double turnDeadMin,double maxSpeed){

        double drive = applyAxisDeadband((GasAxis - BrakeAxis), driveDeadMax, driveDeadMin,maxSpeed,-maxSpeed);
        double turn = applyAxisDeadband(TurnAxisPos, turnDeadMax, turnDeadMin,maxSpeed,-maxSpeed);

        MotorControl.runTalonSRX(leftMaster,(drive + turn));
        MotorControl.runTalonSRX(rightMaster, -(drive - turn));

    }   

}
