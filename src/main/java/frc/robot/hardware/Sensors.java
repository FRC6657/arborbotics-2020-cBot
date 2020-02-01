/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.hardware;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */

public class Sensors extends Subsystem {//Stores the robots different sensors and provides the data from the sensors to the rest of the code

  private Encoder leftEncoder = new Encoder(0,1,true,EncodingType.k4X);
  //private Encoder rightEncoder = new Encoder(2,3,false,EncodingType.k4X);

  //private AHRS navX;//Declares the navX-MPX

  public Sensors(){

    //navX = new AHRS(SPI.Port.kMXP);//Assigns the navX to a port located in the center of the RoboRio

    leftEncoder.setDistancePerPulse(0.00920388472);
    //rightEncoder.setDistancePerPulse(0.00920388472);

  }

  public double getLeftEncoderValue(){return leftEncoder.getDistance();}
  //public double getRightEncoderValue(){return rightEncoder.getDistance();}

  //public void ResetEncoders(){leftEncoder.reset(); rightEncoder.reset();}

  //public double getAngle(){return navX.getAngle();}//Takes the angle from the navX so it can be used elsewhere
  //public void resetAngle(){navX.reset();}//Resets the navX to 0 on all axis

  @Override
  public void initDefaultCommand() {}
}

