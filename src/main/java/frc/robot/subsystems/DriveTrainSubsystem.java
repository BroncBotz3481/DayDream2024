// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveTrainConstants;


public class DriveTrainSubsystem extends SubsystemBase {

   CANSparkMax leftMotor;
   CANSparkMax rightMotor;
   DifferentialDrive driveTrain;
   double multi = driveTrainConstants.basedSpeed;
   double slowed = driveTrainConstants.slowSpeed;

  /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {

    leftMotor = new CANSparkMax(driveTrainConstants.leftMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);
    rightMotor = new CANSparkMax(driveTrainConstants.rightMotorID, com.revrobotics.CANSparkLowLevel.MotorType.kBrushless);


   leftMotor.setIdleMode(IdleMode.kBrake);
   rightMotor.setIdleMode(IdleMode.kBrake);

   rightMotor.setInverted(true);

  driveTrain = new DifferentialDrive(leftMotor,rightMotor);

  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  

  public Command DriveCommand(DoubleSupplier y, DoubleSupplier z) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(
        () -> {
          driveTrain.arcadeDrive(y.getAsDouble() * multi * slowed , z.getAsDouble() * multi *slowed);
        });
  }
  
  public void slowMode(){
    slowed =  driveTrainConstants.slowSpeed;
    System.out.println("SLowmode On");
  } 

  public void notSlowMode(){
    slowed =  1;
    System.out.println("SLowmode Off");
  }
  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}

