package frc.robot.Constants;

public enum ControllerBinds {//Stores all of the controller button mappings in one place for easy editing

    //Joystick
    JouttakeOut(1),
    JouttakeIn(3),
    JintakeOut(5),
    JintakeIn(2),
    JintakePivotUp(6),
    JintakePivotDown(4),

    //Controller
    CouttakeOut(1),
    CouttakeIn(8),
    CintakeOut(7),
    CintakeIn(2),
    CintakePivotUp(6),
    CintakePivotDown(5),
    
    //Andrew's Controlls
    AouttakeOut(6),
    AintakeIn(5),
    AintakeOut(3),
    AouttakeIn(2),
    AintakePivotUp(4),
    AintakePivotDown(1);


    public final int value;
    ControllerBinds(int value){this.value = value;}

}