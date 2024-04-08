// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static edu.wpi.first.wpilibj2.command.CommandGroupBase.runOnce;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrainSubsystem extends SubsystemBase {

  private final CANSparkMax leftMotor;
  private final CANSparkMax rightMotor;


  /** Creates a new ExampleSubsystem. */
  public DriveTrainSubsystem() {


   leftMotor = new CANSparkMax(3, MotorType.kBrushless);
   rightMotor = new CANSparkMax(2, MotorType.kBrushless);

   leftMotor.setIdleMode(IdleMode.kCoast);
   rightMotor.setIdleMode(IdleMode.kCoast);

   rightMotor.setInverted(true);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */

  

  public static Command telopDriveCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
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

