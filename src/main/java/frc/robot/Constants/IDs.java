package frc.robot.Constants;

public enum IDs {

    //CAN
    frontLeftMotor(1),
    backLeftMotor(2),
    frontRightMotor(3),
    backRightMotor(4),
    intakeSpin(5),
    intakePivot(6),
    outtakeL(7),
    outtakeR(8),


    turkeyOneWheel(79),
    //Controllers
    joyStick(0),
    intakeButton(4),
    outtakeButton(6),
    rotationControlButton(200);

    public final int value;
    IDs(int value){this.value = value;}

}