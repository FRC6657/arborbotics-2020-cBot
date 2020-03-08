/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

public class ColorThings extends SubsystemBase {
  /**
   * Creates a new ColorThings.
   */

  private VictorSP m_blinkin;
  private ColorSensorV3 m_colorsensor;

  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = ColorMatch.makeColor(.125, .422, .455);
  private final Color kGreenTarget = ColorMatch.makeColor(.167, .578, .256);
  private final Color kRedTarget = ColorMatch.makeColor(.533, .338, .128);
  private final Color kYellowTarget = ColorMatch.makeColor(.316, .561, .122);

  private String colorString = "No Color";

  public ColorThings() {

    m_colorsensor = new ColorSensorV3(Port.kOnboard);    
    m_blinkin = new VictorSP(6);

    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);

  }

  public void MatchColor() {

    Color detectedColor = m_colorsensor.getColor();

    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);


    //Color String Represents the color the fms is seing. This assumed The sensor is in the middle front of the panel.
    if (match.color == kBlueTarget) {
      colorString = "R";
      //colorString = "B";
      m_blinkin.set(.61);
      //m_blinkin.set(0.87);
    } else if (match.color == kRedTarget) {
      colorString = "B";
      //colorString = "R";
      m_blinkin.set(.87);
      //m_blinkin.set(.61);
    } else if (match.color == kGreenTarget) {
      colorString = "Y";
      //colorString = "G";
      m_blinkin.set(.69);
      //m_blinkin.set(.75);
    } else if (match.color == kYellowTarget) {
      colorString = "G";
      //colorString = "Y";
      m_blinkin.set(.75);
      //m_blinkin.set(.69);
    } else {
      colorString = "Unknown";
      m_blinkin.set(-.99);
    }

    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);
    SmartDashboard.putString("Match Data", getMatchData());

  }

  public String getMatchData(){return DriverStation.getInstance().getGameSpecificMessage();}
  public String getColorString(){return colorString;}
  public void setBlinkin(double color){m_blinkin.set(color);}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    MatchColor();
    //m_blinkin.set(0.75);
  }
}
