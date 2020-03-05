/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
  // Variables

  // Robot vars (not directly related to the vision system)

  XboxController controller;

  WPI_TalonSRX m_frontLeft;
  WPI_VictorSPX m_rearLeft;
  SpeedControllerGroup m_left;

  WPI_TalonSRX m_frontRight;
  WPI_VictorSPX m_rearRight;

  SpeedControllerGroup m_right;

  DifferentialDrive m_drive;

  /*
   * NetworkTable is a collection of databases stored in the RoboRIO The co
   * processor can change data inside it This database can be viewed in a program
   * named OutlineViewer "table" represents a single database called
   * "Shooter Vision" under "chameleon-vision"
   */
  NetworkTable table;
  NetworkTableEntry pipelineEntry;

  /*
   * targetX represents the horizontal angle targetY represents the vertical angle
   */
  NetworkTableEntry targetX;
  NetworkTableEntry targetY;

  // Error values for the control loop
  double rotationError;
  double distanceError;

  // Control loop constants
  /*
   * This uses proportional control loop with constant force .
   */
  double KpRot = -0.1;
  double KpDist = -0.1;

  // Deadzone is necessary because the robot can only get so accurate and cannot
  // be pefectly head on the target
  double angleTolerance = 5;// Deadzone for the angle control loop
  double distanceTolerance = 5;// Deadzone for the distance control loop

  /*
   * There is a minimum power that you need to give to the drivetrain in order to
   * overcome friction It helps the robot move and rotate at low speeds removing
   * the need for an Integral Value
   */
  double constantForce = 0.05;

  /*
   * rotationAjust is rotational signal for the drivetrain distanceAjust is
   * forward signal for the drivetrain
   */
  double rotationAjust;
  double distanceAjust;

  /**
   * This is where the pipelines values are held
   */
  int DriverMode = 0; // No Vision Modifications Pure Camera Stream
  int RobotBait = 1; // Vision to track the robot bait sign

  @Override
  public void robotInit() {
    // Initilazition of robot drivetrain and controller
    controller = new XboxController(1);
    m_frontLeft = new WPI_TalonSRX(1);
    m_rearLeft = new WPI_VictorSPX(2);
    m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
    m_frontRight = new WPI_TalonSRX(3);
    m_rearRight = new WPI_VictorSPX(4);
    m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);

    m_drive = new DifferentialDrive(m_left, m_right);

    // Points "table" to the NetworkTable database called "chameleon-vision"
    table = NetworkTableInstance.getDefault().getTable("chameleon-vision").getSubTable("Shooter Vision");
    // Gets the current pipeline entry so it can be edited to select the desired
    // pipeline.
    pipelineEntry = table.getEntry("pipeline");

    // Points to the database value named "yaw" and "pitch"
    targetX = table.getEntry("yaw");
    targetY = table.getEntry("pitch");
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    /**
     *Sets the vision pipeline to the desired pipeline when Teleop Starts
     *Pipeline selection happens here to make viewing the camera feed easier 
    */
    setPipeline(RobotBait);
  }

  @Override
  public void teleopPeriodic() {

    rotationAjust = 0;
    distanceAjust = 0;
    if (controller.getRawButton(Button.kA.value))// the "A" button
    {
      /*
       * Fetches the rotation and distance values from the raspi sets the value to 0.0
       * if the value doesnt exist in the database
       */
      rotationError = targetX.getDouble(0.0);
      distanceError = targetY.getDouble(0.0);
      /*
       * Proportional (to targetX) control loop for rotation Deadzone of
       * angleTolerance Constant power is added to the direction the control loop
       * wants to turn (to overcome friction)
       */
      if (rotationError > angleTolerance) {
        rotationAjust = KpRot * rotationError + constantForce;
      } else if (rotationError < angleTolerance) {
        rotationAjust = KpRot * rotationError - constantForce;
      }

      /*
       * Proportional (to targetY) control loop for distance Deadzone of
       * distanceTolerance Constant power is added to the direction the control loop
       * wants to turn (to overcome friction)
       */
      /*
      if (distanceError > distanceTolerance) {
        distanceAjust = KpDist * distanceError + constantForce;
      } else if (distanceError < distanceTolerance) {
        distanceAjust = KpDist * distanceError - constantForce;
      }
      */
      /**
       * Smart Dashboard Prints
       */
      SmartDashboard.putNumber("Distance Error: ", distanceError);
      SmartDashboard.putNumber("Distance Ajust: ", distanceAjust);
      SmartDashboard.putNumber("Rotation Error: ", rotationError);
      SmartDashboard.putNumber("Rotation Ajust: ", rotationAjust);

      // Output the power signals to a arcade drivetrain
      //m_drive.arcadeDrive(0, rotationAjust);
    }

  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  public void setPipeline(int index) {
    //Sets the "pipeline" database entry to a given value which selects the desired vision pipeline
    pipelineEntry.setNumber(index);
  }
}
