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

    //Controllers
    joyStick(0);

    public final int value;
    IDs(int value){this.value = value;}

}