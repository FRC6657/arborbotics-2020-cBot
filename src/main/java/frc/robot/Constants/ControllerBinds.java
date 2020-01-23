package frc.robot.Constants;

public enum ControllerBinds {//Stores all of the controller button mappings in one place for easy editing

    //Joystick
    JouttakeOut(1),
    JouttakeIn(4),
    JintakeOut(6),
    JintakeIn(2),
    JintakePivotUp(5),
    JintakePivotDown(3),

    //Controller
    CouttakeOut(4),
    CouttakeIn(2),
    CintakeOut(3),
    CintakeIn(1),
    CintakePivotUp(4),
    CintakePivotDown(5),
    
    //Andrew's Controlls
    AouttakeOut(6),
    AintakeIn(5),
    AintakeOut(8),
    AouttakeIn(7),
    AintakePivotUp(4),
    AintakePivotDown(1);


    public final int value;
    ControllerBinds(int value){this.value = value;}

}