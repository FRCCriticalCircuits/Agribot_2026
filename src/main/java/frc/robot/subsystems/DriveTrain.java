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
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    // Motors
	private TitanQuad rearLeft_motor;
    private TitanQuad rearRight_motor;
    private TitanQuad frontLeft_motor;
    private TitanQuad frontRight_motor;

    // Encoders
    private TitanQuadEncoder rearLeftEncoder;
    private TitanQuadEncoder rearRightEncoder;
    private TitanQuadEncoder frontLeftEncoder;
    private TitanQuadEncoder frontRightEncoder;

    public DriveTrain() {
        rearLeft_motor = new TitanQuad(Constants.TITAN_CAN_ID,Constants.REARLEFT_ID);
        rearRight_motor = new TitanQuad(Constants.TITAN_CAN_ID,Constants.REARRIGHT_ID);
        frontLeft_motor = new TitanQuad(Constants.TITAN_CAN_ID, Constants.FRONTLEFT_ID);
        frontRight_motor = new TitanQuad(Constants.TITAN_CAN_ID,Constants.FRONTRIGHT_ID);

        Timer.delay(1);

        rearLeftEncoder = new TitanQuadEncoder(Constants.REARLEFT_ID, Constants.REAR_LEFT_ENCODER, distPerTick);
    }

    public void setMotorSpeed(TitanQuad motor, double voltage){
        motor.setVoltage(voltage);
    }
    @Override
    public void periodic() {

    }
}
