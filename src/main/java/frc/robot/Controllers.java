/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Commands.outtakeOut;
import frc.robot.Constants.*;

/**
 * Add your docs here.
 */
public class Controllers {

    Joystick joyStick = new Joystick(IDs.joyStick.value);

    Button OuttakeOut = new JoystickButton(this.joyStick, 1);

    public Controllers(){

        this.OuttakeOut.whileHeld(new outtakeOut());

    }
}
