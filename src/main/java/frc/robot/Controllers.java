/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.*;
import frc.robot.Constants.*;

/**
 * Add your docs here.
 */
public class Controllers {

    Joystick joyStick = new Joystick(IDs.joyStick.value);

    XboxController controller = new XboxController(IDs.controller.value);

    Button OuttakeOut;
    Button IntakeIn;

    public String DriverProfile = "Double";

    public Controllers(){

        if(DriverProfile == "Double"){

            OuttakeOut = new JoystickButton(this.controller, ControllerBinds.CouttakeOut.value);
            IntakeIn = new JoystickButton(this.controller, ControllerBinds.CintakeIn.value);


        }
        else if(DriverProfile == "Single"){

            OuttakeOut = new JoystickButton(this.joyStick, ControllerBinds.JouttakeOut.value);
            IntakeIn = new JoystickButton(this.joyStick, ControllerBinds.JintakeIn.value);


     }
     
        else if(DriverProfile == "Andrew"){

        OuttakeOut = new JoystickButton(this.controller, 6);
        IntakeIn = new JoystickButton(this.controller, 5);

        }

        OuttakeOut.whileHeld(new outtakeOut());
        IntakeIn.whileHeld(new intakeIn());
        

    }
    public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}
    public double getControllerAxis(int axis){return controller.getRawAxis(axis);}
}
