package frc.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import gamepad.OI;

public class Teleop extends CommandBase{
    private static final DriveTrain driveTrain = RobotContainer.driveTrain;
    private static final OI oi = RobotContainer.oi;

    double inputLeftY = 0;
    double inputLeftX = 0;
    double inputRightX = 0;

    double deltaLeftY = 0;
    double deltaLeftX = 0;
    double deltaRightX = 0;
    double prevLeftY = 0;
    double prevLeftX = 0;
    double prevRightX = 0;

    public Teleop(){
        addRequirements(driveTrain);
    }

    private static final double RAMP_UP = 0.05;

    private static final double RAMP_DOWN = 0.05;

    private static final double DELTA_LIMIT = 0.075;

    @Override
    public void initialize(){
        driveTrain.resetEncoders();
        driveTrain.resetYaw();
    }

    @Override
    public void execute(){
        inputLeftX = oi.getLeftDriveX();
        inputLeftY = oi.getLeftDriveY();
        inputRightX = oi.getRightDriveX();

        deltaLeftX = inputLeftX - prevLeftX;
        deltaLeftY = inputLeftY - prevLeftY;
        deltaRightX = inputRightX - prevRightX;
        if (deltaLeftX >= DELTA_LIMIT)
            inputLeftX += RAMP_UP;
        else if (deltaLeftX <= -DELTA_LIMIT)
            inputLeftX -= RAMP_DOWN;
        if (deltaLeftY >= DELTA_LIMIT)
            inputLeftY += RAMP_UP;
        else if (deltaLeftY <= -DELTA_LIMIT)
            inputLeftY -= RAMP_DOWN;
        if (deltaRightX >= DELTA_LIMIT)
            inputRightX += RAMP_UP;
        else if (deltaRightX <= -DELTA_LIMIT)
            inputRightX -= RAMP_DOWN;
        prevLeftY = inputLeftY;
        prevLeftX = inputLeftX;
        prevRightX = inputRightX;

        driveTrain.drive(-inputLeftY, inputLeftX, inputRightX);
    }

    @Override
    public void end(boolean interrupted){
        driveTrain.drive(deltaRightX, deltaLeftY, deltaLeftX);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
