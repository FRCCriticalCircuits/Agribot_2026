package gamepad;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    Joystick drivePad;
    public OI(){
        drivePad = new Joystick(GamepadConstants.USB_PORT);

    }
    public double getRightDriveY(){
        double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_Y);

        if(Math.abs(joy) < 0.05){
            return 0.0;
        }else{
            return joy;
        }
    }

    public double getRightDriveX(){
        double joy = drivePad.getRawAxis(GamepadConstants.RIGHT_ANALOG_X);

        if(Math.abs(joy) < 0.05){
            return 0.0;
        }else{
            return joy;
        }
    }

    public double getLeftDriveY()
        {
            double joy = drivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_Y);
            if(Math.abs(joy) < 0.05)
                return 0.0;
            else  
                return joy;
        }
        
    public double getLeftDriveX()
    {
        double joy = drivePad.getRawAxis(GamepadConstants.LEFT_ANALOG_X);
        if(Math.abs(joy) < 0.05)
            return 0.0;
        else
            return joy;
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveRightTrigger()
    {
        return drivePad.getRawButton(GamepadConstants.RIGHT_TRIGGER);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveRightBumper()
    {
        return drivePad.getRawButton(GamepadConstants.RIGHT_BUMPER);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveLeftTrigger()
    {
        return drivePad.getRawButton(GamepadConstants.LEFT_TRIGGER);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveLeftBumper()
    {
        return drivePad.getRawButton(GamepadConstants.LEFT_BUMPER);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveXButton()
    {
        return drivePad.getRawButton(GamepadConstants.SHARE_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveYButton()
    {
        return drivePad.getRawButton(GamepadConstants.TRIANGLE_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveBButton()
    {
        return drivePad.getRawButtonPressed(GamepadConstants.CIRCLE_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveAButton()
    {
        return drivePad.getRawButtonPressed(GamepadConstants.X_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveBackButton()
    {
        return drivePad.getRawButton(GamepadConstants.SHARE_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveStartButton()
    {
        return drivePad.getRawButton(GamepadConstants.OPTIONS_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveRightAnalogButton()
    {
        return drivePad.getRawButton(GamepadConstants.RIGHT_ANALOG_BUTTON);
    }

    /**
     * @return a true or false depending on the input
     */
    public boolean getDriveLeftAnalogButton()
    {
        return drivePad.getRawButton(GamepadConstants.LEFT_ANALOG_BUTTON);
    }

    /**
     * @return the numeric value of the D Pad hat. D UP is 0 and rotates CW. Ex D Right is 90, D Down is 180 
     */
    public int getPOV()
    {
        return drivePad.getPOV();
    }
}
