// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
// import frc.robot.commands.Autos;
// import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
 
    private final DriveTrainSubsystem m_DriveTrainSubsystem = new DriveTrainSubsystem();

    private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
  
    m_DriveTrainSubsystem.setDefaultCommand(
        m_DriveTrainSubsystem.DriveCommand(
          m_driverController :: getLeftY,
          m_driverController :: getRightX));
    
      m_driverController.rightBumper().whileTrue(new InstantCommand(m_DriveTrainSubsystem::slowMode));
      m_driverController.rightBumper().whileFalse(new InstantCommand(m_DriveTrainSubsystem::notSlowMode));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
