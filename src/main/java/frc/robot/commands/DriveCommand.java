// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveCommand extends Command {

  private final DriveSubsystem driveSubsystem;
  private final DoubleSupplier verticalPower;
  private final DoubleSupplier horizontalPower;

  /** Creates a new DriveCommand. */
  public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier verticalPower, DoubleSupplier horizontalPower) {
    this.driveSubsystem = driveSubsystem;
    this.verticalPower = verticalPower;
    this.horizontalPower = horizontalPower;

    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!isWithinTolerance(verticalPower.getAsDouble(), 0, 0.075)) {
      driveSubsystem.runDrive(verticalPower.getAsDouble());
    } else if (!isWithinTolerance(horizontalPower.getAsDouble(), 0, 0.075)) {
      driveSubsystem.runDrive(horizontalPower.getAsDouble(), -horizontalPower.getAsDouble());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  driveSubsystem.runDrive(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  private static boolean isWithinTolerance(double value, double target, double tolerance) {
    return (value >= target - tolerance) && (value <= target + tolerance);
  }
}
