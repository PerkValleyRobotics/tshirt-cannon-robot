// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private final VictorSPX leftFrontDrive;
  private final VictorSPX leftBackDrive;
  private final VictorSPX rightFrontDrive;
  private final VictorSPX rightBackDrive;

  public DriveSubsystem() {
    leftFrontDrive = new VictorSPX(0);
    leftBackDrive = new VictorSPX(1);
    rightFrontDrive = new VictorSPX(2);
    rightBackDrive = new VictorSPX(3);
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
    leftFrontDrive.set(ControlMode.PercentOutput, power);
    leftBackDrive.set(ControlMode.PercentOutput, power);
  }

  public void runLeftDrive() {
    runLeftDrive(0.75);
  }

  public void runRightDrive(double power) {
    rightFrontDrive.set(ControlMode.PercentOutput, power);
    rightBackDrive.set(ControlMode.PercentOutput, power);
  }

  public void runRightDrive() {
    runRightDrive(0.75);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
