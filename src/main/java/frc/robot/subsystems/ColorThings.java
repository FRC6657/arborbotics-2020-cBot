/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ColorConstants;

import java.util.Map;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

public class ColorThings extends SubsystemBase {
  /**
   * Creates a new ColorThings.
   */

  private VictorSP m_blinkin = new VictorSP(0); 
  private ColorSensorV3 m_colorsensor;

  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kRedTarget = ColorConstants.RED_TARGET;
  private final Color kGreenTarget = ColorConstants.GREEN_TARGET;
  private final Color kBlueTarget = ColorConstants.BLUE_TARGET;
  private final Color kYellowTarget = ColorConstants.YELLOW_TARGET;
  private final Color kLoweredTarget = ColorConstants.LOWERED_TARGET;

  private String colorString = "No Color";

  public ColorThings() {
    
      m_colorsensor = new ColorSensorV3(Port.kOnboard);

      m_colorMatcher.addColorMatch(kBlueTarget);
      m_colorMatcher.addColorMatch(kGreenTarget);
      m_colorMatcher.addColorMatch(kRedTarget);
      m_colorMatcher.addColorMatch(kYellowTarget);
      m_colorMatcher.addColorMatch(kLoweredTarget);

  }

  public void matchColor() {

    Color detectedColor = m_colorsensor.getColor();

    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    // Color String Represents the color the fms is seing. This assumed The sensor
    // is in the middle front of the panel.
    if (match.color.equals(kRedTarget)) {

      colorString = "B";
      m_blinkin.set(blinkin_colors.SOLID_DARK_BLUE.color);

    } else if (match.color.equals(kGreenTarget)) {

      colorString = "Y";
      m_blinkin.set(blinkin_colors.SOLID_GOLD.color);

    } else if (match.color.equals(kBlueTarget)) {

      colorString = "R";
      m_blinkin.set(blinkin_colors.SOLID_DARK_RED.color);

    } else if (match.color.equals(kYellowTarget)) {

      colorString = "G";
      m_blinkin.set(blinkin_colors.SOLID_DARK_GREEN.color);

    } 
    else if (match.color.equals(kLoweredTarget)) {

      colorString = "L";
      m_blinkin.set(blinkin_colors.RAINBOW_PALETTE.color);

    } 
    else {
      colorString = "Unknown";
      m_blinkin.set(blinkin_colors.SOLID_WHITE.color);
    }

    
      SmartDashboard.putNumber("Red", detectedColor.red);
      SmartDashboard.putNumber("Green", detectedColor.green);
      SmartDashboard.putNumber("Blue", detectedColor.blue);
      SmartDashboard.putNumber("Confidence", match.confidence);
      SmartDashboard.putString("Detected Color", colorString);
      SmartDashboard.putString("Match Data", getMatchData());

    
  }

  public String getMatchData() {
    return DriverStation.getInstance().getGameSpecificMessage();
  }

  public String getColorString() {
    return colorString;
  }

  public void setBlinkin(double color) {
    m_blinkin.set(color);
  }

  public enum blinkin_colors {
    RAINBOW_PALETTE(-99), PARTY_PALETTE(-97), OCEAN_PALETTE(-95), LAVA_PALETTE(-93), FOREST_PALETTE(-91),
    RAINBOW_WITH_GLITTER(-89), CONFETTI(-87), SHOT_RED(-85), SHOT_BLUE(-83), SHOT_WHITE(-81),
    SINELEON_RAINBOW_PALETTE(-79), SINELEON_PARTY_PALETTE(-77), SINELEON_OCEAN_PALETTE(-75), SINELEON_LAVA_PALETTE(-73),
    SINELEON_FOREST_PALETTE(-71), BEATS_PER_MINUTE_RAINBOW_PALETTE(-69), BEATS_PER_MINUTE_PARTY_PALETTE(-67),
    BEATS_PER_MINUTE_OCEAN_PALETTE(-65), BEATS_PER_MINUTE_LAVA_PALETTE(-63), BEATS_PER_MINUTE_FOREST_PALETTE(61),
    FIRE_MEDIUM(-59), FIRE_LARGE(-57), TWINKLES_RAINBOW_PALETTE(-55), TWINKLES_PARTY_PALETTE(-53),
    TWINKLES_OCEAN_PALETTE(-51), TWINKLES_LAVA_PALETTE(-49), TWINKLES_FOREST_PALETTE(-47),
    COLOR_WAVES_RAINBOW_PALETTE(-45), COLOR_WAVES_PARTY_PALETTE(-43), COLOR_WAVES_OCEAN_PALETTE(-41),
    COLOR_WAVES_LAVA_PALETTE(-39), COLOR_WAVES_FOREST_PALETTE(-37), LARSON_SCANNER_RED(-35), LARSON_SCANNER_GRAY(-33),
    LIGHT_CHASE_RED(-31), LIGHT_CHASE_BLUE(-29), LIGHT_CHASE_GRAY(-27), HEARTBEAT_RED(-25), HEARTBEAT_BLUE(-23),
    HEARTBEAT_WHITE(-21), HEARTBEAT_GRAY(-19), BREATH_RED(-17), BREATH_BLUE(-15), BREATH_GRAY(-13), STROBE_RED(-11),
    STROBE_BLUE(-9), STROBE_GOLD(-7), STROBE_WHITE(-5), COLOR_1_END_TO_END_BLACK_TO_BLACK(-3),
    COLOR_1_LARSON_SCANNER(-1), COLOR_1_LIGHT_CHASE(1), COLOR_1_HEARTBEAT_SLOW(3), COLOR_1_HEARBEAT_MEDIUM(5),
    COLOR_1_HEARTBEAT_FAST(7), COLOR_1_BREATH_SLOW(9), COLOR_1_BREATH_FAST(11), COLOR_1_SHOT(13), COLOR_1_STROBE(15),
    COLOR_2_END_TO_END_BLACK_TO_BLACK(17), COLOR_2_LARSON_SCANNER(19), COLOR_2_LIGHT_CHASE(21),
    COLOR_2_HEARTBEAT_SLOW(23), COLOR_2_HEARBEAT_MEDIUM(25), COLOR_2_HEARTBEAT_FAST(27), COLOR_2_BREATH_SLOW(29),
    COLOR_2_BREATH_FAST(31), COLOR_2_SHOT(33), COLOR_2_STROBE(35), COLOR_1_COLOR_2_SPARKLE_C1_ON_C2(37),
    COLOR_1_COLOR_2_SPARKLE_2_ON_C1(39), COLOR_1_COLOR_2_GRADIENT(41), COLOR_1_COLOR_2_BEATS_PER_MINUTE(43),
    COLOR_1_COLOR_2_END_TO_END_BLEND_1_TO_2(45), COLOR_1_COLOR_2_END_TO_END_BLEND(47),
    COLOR_1_COLOR_2_COLOR_1_AND_COLOR_2(49), COLOR_1_COLOR_2_TWINKLES(51), COLOR_1_COLOR_2_WAVES(53),
    COLOR_1_COLOR_2_SINELON(55), SOLID_HOT_PINK(57), SOLID_DARK_RED(59), SOLID_RED(61), SOLID_RED_ORANGE(63),
    SOLID_ORANGE(65), SOLID_GOLD(67), SOLID_YELLOW(69), SOLID_LAWN_GREEN(71), SOLID_LIME(73), SOLID_DARK_GREEN(75),
    SOLID_GREEN(77), SOLID_BLUE_GREEN(79), SOLID_AQUA(81), SOLID_SKY_BLUE(83), SOLID_DARK_BLUE(85), SOLID_BLUE(87),
    SOLID_BLUE_VIOLET(89), SOLID_VIOLET(91), SOLID_WHITE(93), SOLID_GRAY(95), SOLID_DARK_GRAY(97), SOLID_BLACK(99);

    public final double color;

    blinkin_colors(double color) {
      this.color = color / 100;
    }
  }

  @Override
  public void periodic() {

    matchColor();

  }
}
