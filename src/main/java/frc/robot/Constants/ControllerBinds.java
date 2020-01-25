package frc.robot.Constants;

public enum ControllerBinds {
    //Stores all of the controller button mappings in one place for easy editing

    //0=Unbound

    //Joystick
    JouttakeOut(1),
    JouttakeIn(3),
    JintakeOut(5),
    JintakeIn(2),

    //Controller
    CouttakeOut(1),
    CouttakeIn(8),
    CintakeOut(7),
    CintakeIn(2),
    
    //Andrew's Controls
    AouttakeOut(6),
    AintakeIn(5),
    AintakeOut(0),
    AouttakeIn(0);


    public final int value;
    ControllerBinds(int value){this.value = value;}

}