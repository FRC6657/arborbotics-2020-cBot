package frc.robot.Constants;

public enum IDs {//Stores all of the id values such as controllers and CAN

    //CAN
    frontLeftMotor(1),
    backLeftMotor(2),
    frontRightMotor(3),
    backRightMotor(4),
    intakeSpin(5),
    intakePivot(6),
    outtakeL(7),
    outtakeR(8),
    liftMotor(9),

    //Controllers
    joyStick(0),
    controller(1);

    public final int value;
    IDs(int value){this.value = value;}

}