/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.custom_classes;

import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * Add your docs here.
 */
public class DPad extends Button {

    private ACCTWEMAS controller;
    private Direction direction;

    public DPad(ACCTWEMAS controller, Direction direction) {
        this.controller = controller;
        this.direction = direction;
    }

    @Override
    public boolean get() {
        int degree = controller.getDPad();

        return degree == direction.degree;
    }

    public enum Direction {
        Up(0), Down(180), Left(270), Right(90);

        int degree;

        Direction(int degree) {
            this.degree = degree;
        }
    }
}
