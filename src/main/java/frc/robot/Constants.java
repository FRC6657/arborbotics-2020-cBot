package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.util.Color;

public class Constants {

    public static final class ColorConstants{

        public static final int BLINKIN_PWM = 6;

        public static final Color RED_TARGET = ColorMatch.makeColor(.533, .338, .128);
        public static final Color GREEN_TARGET = ColorMatch.makeColor(.167, .578, .256);
        public static final Color BLUE_TARGET = ColorMatch.makeColor(.125, .422, .455);
        public static final Color YELLOW_TARGET = ColorMatch.makeColor(.316, .561, .122);
        public static final Color LOWERED_TARGET = null;

    }

    public static final class JoystickButtons{

        public static final int TRIGGER = 1;
        public static final int SIDE = 2;
        public static final int BOTTOM_LEFT = 3;
        public static final int BOTTOM_RIGHT = 4;
        public static final int TOP_LEFT = 5;
        public static final int TOP_RIGHT = 6;
        public static final int _7 = 7;
        public static final int _8 = 8;
        public static final int _9 = 9;
        public static final int _10 = 10;
        public static final int _11 = 11;
        public static final int _12 = 12;

    }

    public static final class DriveConstants {

        public static final double DRIVE_MULTIPLIER = 0.65;
        public static final double TURN_MULTIPLIER = 0.65;

        public static final int DRIVE_AXIS = 1;
        public static final int TURN_AXIS = 2;

        public static final double DRIFT_AJUST = 0.1;

        public static final double STICK_DEADBAND = 0.2;
        public static final double TWIST_DEADBAND = 0.1;
        public static final double TRIGGER_DEADBAND = 0.2;

        public static final int FRONT_LEFT_ID = 1;
        public static final int FRONT_RIGHT_ID = 3;
        public static final int BACK_LEFT_ID = 2;
        public static final int BACK_RIGHT_ID = 4;

    }

    public static final class ServoConstants {
        // Camera Angles
        public static final double LINE_ANGLE = 120;
        public static final double FIRE_ANGLE = 75;
        public static final double INTAKE_ANGLE = 15;
        public static final double LIFT_ANGLE = 135;

        public static final double GATE_UP_ANGLE = 115;
        public static final double GATE_DOWN_ANGLE = 167;

        public static final int GATE_PWM = 9;
        public static final int OUTTAKE_CAMERA_PWM = 8;
        public static final int INTAKE_CAMERA_PWM = 7;

    }

    public static final class AgitatorConstants {

        public static final double SPEED = 1;
        public static final int ID = 9;

    }

    public static final class ControlPanelConstants {

        public static final double PIVOT_SPEED = 1;
        public static final double ROTATE_SPEED = 0.4;

        public static final int PIVOT_ID = 10;
        public static final int SPIN_ID = 11;

    }

    public static final class IntakeConstants {

        public static final double SPEED = 0.4;
        public static final int ID = 5;

    }

    public static final class LiftConstants {

        public static final double SPEED = 0.65;
        public static final int ID = 6;

    }

    public static final class OuttakeConstants {

        public static final double SPEED = 0.8;
        public static final int LEFT_ID = 7;
        public static final int RIGHT_ID = 8;

    }

}