// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private final SparkMax leftFrontDrive;
  private final SparkMax leftBackDrive;
  private final SparkMax rightFrontDrive;
  private final SparkMax rightBackDrive;

  public DriveSubsystem() {
    leftFrontDrive = new SparkMax(0, MotorType.kBrushless);
    leftBackDrive = new SparkMax(1, MotorType.kBrushless);
    rightFrontDrive = new SparkMax(2, MotorType.kBrushless);
    rightBackDrive = new SparkMax(3, MotorType.kBrushless);
  }

  public void runDrive(double power) {
    runLeftDrive(power);
    runRightDrive(power);
  }

  public void runDrive(double leftPower, double rightPower) {
    runLeftDrive(leftPower);
    runRightDrive(rightPower);
  }

  public void runDrive() {
    runDrive(0.75);
  }

  public void runLeftDrive(double power) {
    leftFrontDrive.set(power);
    leftBackDrive.set(power);
  }

  public void runLeftDrive() {
    runLeftDrive(0.75);
  }

  public void runRightDrive(double power) {
    rightFrontDrive.set(power);
    rightBackDrive.set(power);
  }

  public void runRightDrive() {
    runRightDrive(0.75);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
