/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj2.command.Command;
import frc.Commands.Teleop;
import frc.robot.subsystems.DriveTrain;
import gamepad.OI;


public class RobotContainer {
  public static DriveTrain driveTrain;
  public static OI oi;
  
  public RobotContainer() {
    driveTrain = new DriveTrain();
    oi = new OI();
    
    driveTrain.setDefaultCommand(new Teleop());
    
    configureButtonBindings();
  }

  private void configureButtonBindings() {
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
