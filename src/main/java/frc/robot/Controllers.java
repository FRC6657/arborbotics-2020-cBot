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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Commands.*;
import frc.robot.Constants.*;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class Controllers {

    Joystick joyStick = new Joystick(IDs.joyStick.value);

    XboxController controller = new XboxController(IDs.controller.value);

    int OuttakeOutBTN = 1;
    int IntakeInBTN = 2;

    Button OuttakeOut;
    Button IntakeIn;

    String SelectedProfile = Robot.selectedProfile;

    public Controllers(){

        if(SelectedProfile == "Double"){

            OuttakeOut = new JoystickButton(this.controller, ControllerBinds.CouttakeOut.value);
            IntakeIn = new JoystickButton(this.controller, ControllerBinds.CintakeIn.value);
    
            OuttakeOut.whileHeld(new outtakeOut());
            IntakeIn.whileHeld(new intakeIn());

        }
        else if(SelectedProfile == "Single"){
            
            OuttakeOut = new JoystickButton(this.controller, ControllerBinds.JouttakeOut.value);
            IntakeIn = new JoystickButton(this.controller, ControllerBinds.JintakeIn.value);
    
            OuttakeOut.whileHeld(new outtakeOut());
            IntakeIn.whileHeld(new intakeIn());

        }
     
        else if(SelectedProfile == "Andrew"){
            
            OuttakeOut = new JoystickButton(this.controller, ControllerBinds.AouttakeOut.value);
            IntakeIn = new JoystickButton(this.controller, ControllerBinds.AintakeIn.value);
    
            OuttakeOut.whileHeld(new outtakeOut());
            IntakeIn.whileHeld(new intakeIn());
        }
    }
    public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}
    public double getControllerAxis(int axis){return controller.getRawAxis(axis);}

}
