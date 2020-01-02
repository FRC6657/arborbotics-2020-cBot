package frc.robot.Constants;

public enum IDs {

    //CAN
    frontLeftMotor(1),
    frontRightMotor(2),
    backLeftMotor(3),
    backRightMotor(4),
    //Controllers
    joyStick(0);

    public final int value;
    IDs(int value){this.value = value;}

}