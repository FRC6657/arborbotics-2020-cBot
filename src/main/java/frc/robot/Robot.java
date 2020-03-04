/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  public static SendableChooser<String> profileChooser = new SendableChooser<>();

  UsbCamera camera1;
  UsbCamera camera2;

  MjpegServer server1;
  MjpegServer server2;

  @Override
	public void robotInit() {

      CameraServer instance1  = CameraServer.getInstance();
      CameraServer instance2 = CameraServer.getInstance();

      camera1 = new UsbCamera("Outtake Camera", 0);
      camera2 = new UsbCamera("Intake Camera", 1);
      instance1.addCamera(camera1);
      instance2.addCamera(camera2);
      server1 = instance1.addServer("server_OuttakeCamera");
      server2 = instance2.addServer("server_IntakeCamera");
      server1.setSource(camera1);
      server2.setSource(camera2);
      server1.getProperty("compression").set(80);
      server2.getProperty("compression").set(80);
      server1.getProperty("default_compression").set(80);
      server2.getProperty("default_compression").set(80);
      server1.setResolution(400, 300);
      server2.setResolution(400, 300);
      server1.setFPS(10);
      server2.setFPS(10);

      Shuffleboard.getTab("Main").add(camera1).withPosition(1, 2).withSize(6, 5);
      Shuffleboard.getTab("Main").add(camera2).withPosition(8, 2).withSize(6, 5);

    m_robotContainer = new RobotContainer();

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
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
