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

    Button JOuttakeOut = new JoystickButton(this.joyStick, ControllerBinds.JouttakeOut.value);
    Button JIntakeIn = new JoystickButton(this.joyStick, ControllerBinds.JintakeIn.value);
    Button JIntakePivotUp = new JoystickButton(this.joyStick, ControllerBinds.JintakePivotUp.value);
    Button JIntakePivotDown = new JoystickButton(this.joyStick, ControllerBinds.JintakePivotDown.value);

    Button COuttakeOut = new JoystickButton(this.controller, ControllerBinds.CouttakeOut.value);
    Button CIntakeIn = new JoystickButton(this.controller, ControllerBinds.CintakeIn.value);
    Button CIntakePivotUp = new JoystickButton(this.controller, ControllerBinds.CintakePivotUp.value);
    Button CIntakePivotDown = new JoystickButton(this.controller, ControllerBinds.CintakePivotDown.value);

    Button AOuttakeOut = new JoystickButton(this.controller, ControllerBinds.AouttakeOut.value);
    Button AIntakeIn = new JoystickButton(this.controller, ControllerBinds.AintakeIn.value);
    Button AIntakePivotUp = new JoystickButton(this.controller, ControllerBinds.AintakePivotUp.value);
    Button AIntakePivotDown = new JoystickButton(this.controller, ControllerBinds.AintakePivotDown.value);

    public Integer DriverProfile = 2;

    public Controllers(){

        if(DriverProfile == 1){
            this.JOuttakeOut.whileHeld(new outtakeOut());
            this.JIntakeIn.whileHeld(new intakeIn());
            this.JIntakePivotUp.whileHeld(new intakePivotUp());
            this.JIntakePivotDown.whileHeld(new intakePivotDown());     
        }
       else if(DriverProfile == 2){

            this.COuttakeOut.whileHeld(new outtakeOut());
            this.CIntakeIn.whileHeld(new intakeIn());
            this.CIntakePivotUp.whileHeld(new intakePivotUp());
            this.CIntakePivotDown.whileHeld(new intakePivotDown());     

        }
        else if(DriverProfile == 3){

            this.AOuttakeOut.whileHeld(new outtakeOut());
            this.AIntakeIn.whileHeld(new intakeIn());
            this.AIntakePivotUp.whileHeld(new intakePivotUp());
            this.AIntakePivotDown.whileHeld(new intakePivotDown());

        }
    }
    public double getJoyAxis(int axis){return joyStick.getRawAxis(axis);}
    public double getControllerAxis(int axis){return controller.getRawAxis(axis);}
}
