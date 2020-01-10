package frc.robot.Constants;

public enum ControllerBinds {

    //Joystick
    outtakeOut(1),
    outtakeIn(4),
    intakeOut(6),
    intakeIn(2),
    intakePivotUp(5),
    intakePivotDown(3);

    //Controller
    public final int value;
    ControllerBinds(int value){this.value = value;}

}