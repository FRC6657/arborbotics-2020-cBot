package frc.robot.Constants;

public enum IDs {

    //CAN
    frontLeftMotor(1),
    frontRightMotor(2),
    backLeftMotor(3),
    backRightMotor(4),

    turkeyOneWheel(79),
    //Controllers
    joyStick(0),
    intakeButton(4),
    outtakeButton(6),
    rotationControlButton(200);

    public final int value;
    IDs(int value){this.value = value;}

}