package frc.robot.Constants;

public enum ControllerBinds {
    //Stores all of the controller button mappings in one place for easy editing

    //0=Unbound

    //Joystick
    JouttakeOut(1),
    JouttakeIn(3),
    JintakeOut(5),
    JintakeIn(2),
    JDriveAxis(2),
    JTurnAxis(1),

    //Controller
    CouttakeOut(1),
    CouttakeIn(8),
    CintakeOut(7),
    CintakeIn(2),
    
    //Andrew's Controls
    AouttakeOut(6),
    AintakeIn(5),
    ATurnAxis(0),
    AGasAxis(3),
    ABrakeAxis(2);
    


    public final int value;
    ControllerBinds(int value){this.value = value;}

}