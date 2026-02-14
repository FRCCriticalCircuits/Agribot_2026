/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.studica.frc.TitanQuad;
import com.studica.frc.TitanQuadEncoder;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    // Motors
	private TitanQuad rearLeft_motor;
    private TitanQuad rearRight_motor;
    private TitanQuad frontLeft_motor;
    private TitanQuad frontRight_motor;

    // Encoders
    private static TitanQuadEncoder rearLeftEncoder;
    private static TitanQuadEncoder rearRightEncoder;
    private static TitanQuadEncoder frontLeftEncoder;
    private static TitanQuadEncoder frontRightEncoder;

    private MecanumDrive robotDrive;

    public DriveTrain() {
        rearLeft_motor = new TitanQuad(Constants.TITAN_CAN_ID,Constants.REARLEFT_ID);
        rearRight_motor = new TitanQuad(Constants.TITAN_CAN_ID,Constants.REARRIGHT_ID);
        frontLeft_motor = new TitanQuad(Constants.TITAN_CAN_ID, Constants.FRONTLEFT_ID);
        frontRight_motor = new TitanQuad(Constants.TITAN_CAN_ID,Constants.FRONTRIGHT_ID);

        Timer.delay(1);

        // Printout Titan Diagnostic data
        System.out.println("Titan Serial number: " + rearLeft_motor.getSerialNumber());
        System.out.println("Titan Serial number: " + rearRight_motor.getSerialNumber());
        System.out.println("Titan Serial number: " + frontLeft_motor.getSerialNumber());
        System.out.println("Titan Serial number: " + frontRight_motor.getSerialNumber());

        System.out.println("Titan ID: " + rearLeft_motor.getSerialNumber());
        System.out.println("Titan ID: " + rearRight_motor.getSerialNumber());
        System.out.println("Titan ID: " + frontLeft_motor.getSerialNumber());
        System.out.println("Titan ID: " + frontRight_motor.getSerialNumber());

        System.out.println("Titan: " + rearLeft_motor.getFirmwareVersion());
        System.out.println("Titan: " + rearRight_motor.getFirmwareVersion());
        System.out.println("Titan: " + frontLeft_motor.getFirmwareVersion());
        System.out.println("Titan: " + frontRight_motor.getFirmwareVersion());

        System.out.println("Titan " + rearLeft_motor.getHardwareVersion());
        System.out.println("Titan " + rearRight_motor.getHardwareVersion());
        System.out.println("Titan " + frontLeft_motor.getHardwareVersion());
        System.out.println("Titan " + frontRight_motor.getHardwareVersion());

        rearLeftEncoder = new TitanQuadEncoder(rearLeft_motor, Constants.REARLEFT_ID, Constants.DIST_PER_TICK);
        rearRightEncoder = new TitanQuadEncoder(rearRight_motor, Constants.REARRIGHT_ID, Constants.DIST_PER_TICK);
        frontLeftEncoder = new TitanQuadEncoder(frontLeft_motor, Constants.FRONTLEFT_ID, Constants.DIST_PER_TICK);
        frontRightEncoder = new TitanQuadEncoder(frontRight_motor, Constants.FRONTRIGHT_ID, Constants.DIST_PER_TICK);

        // Encoder Direction
        rearLeftEncoder.setReverseDirection();
        frontLeftEncoder.setReverseDirection();
        // rearRightEncoder.setReverseDirection();
        // frontRightEncoder.setReverseDirection();

        // RPM Direction
        frontRight_motor.invertRPM();
        rearRight_motor.invertRPM();
        // frontLeft_motor.invertRPM();
        // rearLeft_motor.invertRPM();
        
        rearLeft_motor.setInverted(true);
        frontLeft_motor.setInverted(true);
        rearRight_motor.setInverted(true);
        frontRight_motor.setInverted(true);

        // Drive Setup
        robotDrive = new MecanumDrive(frontLeft_motor, rearLeft_motor, frontRight_motor, rearRight_motor);
        robotDrive.setDeadband(0.05);

        
    }

    public void setMotorSpeed(TitanQuad motor, double voltage){
        motor.setVoltage(voltage);
    }

    public static void resetEncoders(){
        rearLeftEncoder.reset();
        rearRightEncoder.reset();
        frontLeftEncoder.reset();
        frontRightEncoder.reset();
    }

    public void resetYaw(){

    }

    public void drive(double x, double y, double z){
        robotDrive.driveCartesian(y, x, z);
    }

    public double getLeftBackEncoderDistance(){
        return rearLeftEncoder.getEncoderDistance();
    }

    public double getLeftFrontEncoderDistance(){
        return frontLeftEncoder.getEncoderDistance();
    }

    public double getRightRearEncoderDistance(){
        return rearRightEncoder.getEncoderDistance();
    }

    public double getRightFrontEncoderDistance(){
        return frontRightEncoder.getEncoderDistance();
    }

    public double getLeftFrontRPM(){
        return frontLeft_motor.getRPM();
    }

    public double getRightFrontRPM(){
        return frontRight_motor.getRPM();
    }

    public double getLeftRearRPM(){
        return rearLeft_motor.getRPM();
    }

    public double getRightRearRPM(){
        return rearRight_motor.getRPM();
    }
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Rear Left Encoder", getLeftBackEncoderDistance());
        SmartDashboard.putNumber("Rear Left RPM", getLeftRearRPM());

        SmartDashboard.putNumber("Front Left Encoder", getLeftFrontEncoderDistance());
        SmartDashboard.putNumber("Front Left RPM", getLeftFrontRPM());

        SmartDashboard.putNumber("Rear Right Encoder", getRightRearEncoderDistance());
        SmartDashboard.putNumber("Rear Right RPM", getRightRearRPM());

        SmartDashboard.putNumber("Front Right Encoder", getRightFrontEncoderDistance());
        SmartDashboard.putNumber("Front Right RPM", getRightFrontRPM());
    }
}
