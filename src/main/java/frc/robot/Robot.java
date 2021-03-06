// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Layer.layer;
import frc.robot.Layer.robotbase;
import frc.robot.Layer.layer.mode;
import frc.robot.DriveTrain.*;
import frc.robot.InputDevices.*;
import frc.robot.Mec.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  public layer Layer;
  public tankdrive DriveTrain;
  public xbox x_controller;
  public shooter b_shooter;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    Layer = new layer();
    DriveTrain = new tankdrive(Layer);
    x_controller = new xbox(0, Layer);
    b_shooter =  new shooter(Layer);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    Layer.DisplayVar();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    Layer.SetRobotMode(mode.TELEOP /*auto*/);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    Layer.SetRobotMode(mode.TELEOP /*teleop*/);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //motor.set(0.1);
    x_controller.OutputIntoLayer();
    DriveTrain.drive();
    b_shooter.drive();
    

  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {
    Layer.resetALL();
    Layer.SetRobotMode(mode.DISABLED /*disabled*/);
  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
    Layer.ProtectUser();
  }

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {
    Layer.SetRobotMode(mode.TEST /*test*/);
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {

  }
}
