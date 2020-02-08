package frc.robot.CustomClasses; // Change to whatever package you would like

/* Imports */
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.*;

public class XCon extends Joystick {

    private static final double DEFAULT_THUMBSTICK_DEADZONE = 0.1; // Jiggle room for the thumbsticks
    private static final double DEFAULT_TRIGGER_DEADZONE = 0.01; // Jiggle room for the triggers
    private static final double DEFAULT_TRIGGER_SENSITIVITY = 0.6; // If the trigger is beyond this limit, say it has
                                                                   // been pressed

    /* Button Mappings */
    private static final int A_BUTTON_ID = 1;
    private static final int B_BUTTON_ID = 2;
    private static final int X_BUTTON_ID = 3;
    private static final int Y_BUTTON_ID = 4;
    private static final int LB_BUTTON_ID = 5;
    private static final int RB_BUTTON_ID = 6;
    private static final int BACK_BUTTON_ID = 7;
    private static final int START_BUTTON_ID = 8;
    private static final int LEFT_THUMBSTIKC_BUTTON_ID = 9;
    private static final int RIGHT_THUMBSTICK_BUTTON_ID = 10;

    /* Axis Mappings */
    private static final int LEFT_THUMBSTICK_X_AXIS_ID = 0;
    private static final int LEFT_THUMBSTICK_Y_AXIS_ID = 1;
    private static final int LEFT_TRIGGER_AXIS_ID = 2;
    private static final int RIGHT_TRIGGER_AXIS_ID = 3;
    private static final int RIGHT_THUMBSTICK_X_AXIS_ID = 4;
    private static final int RIGHT_THUMBSTICK_Y_AXIS_ID = 5;

    /* Instance Values */
    private final int port;
    private final Joystick controller;

    public final Thumbstick leftStick;
    public final Thumbstick rightStick;
    public final Trigger lt;
    public final Trigger rt;
    public final DirectionalPad dPad;
    public final Button a;
    public final Button b;
    public final Button x;
    public final Button y;
    public final Button lb;
    public final Button rb;
    public final Button back;
    public final Button start;

    public XCon(final int port) {
        super(port);

        this.port = port;
        this.controller = new Joystick(this.port);

        this.leftStick = new Thumbstick(this.controller, HAND.LEFT);
        this.rightStick = new Thumbstick(this.controller, HAND.RIGHT);
        this.dPad = new DirectionalPad(this.controller);
        this.lt = new Trigger(this.controller, HAND.LEFT);
        this.rt = new Trigger(this.controller, HAND.RIGHT);
        this.a = new JoystickButton(this.controller, A_BUTTON_ID);
        this.b = new JoystickButton(this.controller, B_BUTTON_ID);
        this.x = new JoystickButton(this.controller, X_BUTTON_ID);
        this.y = new JoystickButton(this.controller, Y_BUTTON_ID);
        this.lb = new JoystickButton(this.controller, LB_BUTTON_ID);
        this.rb = new JoystickButton(this.controller, RB_BUTTON_ID);
        this.back = new JoystickButton(this.controller, BACK_BUTTON_ID);
        this.start = new JoystickButton(this.controller, START_BUTTON_ID);
    }

    public XCon() {
        this(0);
    }

    public static enum HAND {
        LEFT, RIGHT
    }

    public static enum DPAD {
        UP(0), UP_RIGHT(45), RIGHT(90), DOWN_RIGHT(135), DOWN(180), DOWN_LEFT(225), LEFT(270), UP_LEFT(315);

        public int value;

        DPAD(final int value) {
            this.value = value;
        }

        public static DPAD getEnum(int angle) {
            angle = Math.abs(angle);
            angle %= 360;
            angle = Math.round(angle / 45) * 45;

            DPAD[] all = DPAD.values();

            for (int i = 0; i < all.length; i++) {
                if (all[i].value == angle) {
                    return all[i];
                }
            }

            System.out.println("[XboxController.DPAD.getEnum()] Angle supplied (" + angle + ") has no related DPad direction");
            return DPAD.UP;
        }
    }

 
    public static class Thumbstick extends Button {

        private final Joystick parent;
        private final HAND hand;
        private final int xAxisID;
        private final int yAxisID;
        private final int pressedID;
        private double xDeadZone;
        private double yDeadZone;

        public Thumbstick(final Joystick parent, final HAND hand) {

            this.parent = parent;
            this.hand = hand;
            this.xDeadZone = DEFAULT_THUMBSTICK_DEADZONE;
            this.yDeadZone = DEFAULT_THUMBSTICK_DEADZONE;

            if (hand == HAND.LEFT) {
                this.xAxisID = LEFT_THUMBSTICK_X_AXIS_ID;
                this.yAxisID = LEFT_THUMBSTICK_Y_AXIS_ID;
                this.pressedID = LEFT_THUMBSTIKC_BUTTON_ID;
            } else {
                this.xAxisID = RIGHT_THUMBSTICK_X_AXIS_ID;
                this.yAxisID = RIGHT_THUMBSTICK_Y_AXIS_ID;
                this.pressedID = RIGHT_THUMBSTICK_BUTTON_ID;
            }
        }

        private double rawX() {
            final double rawInput = parent.getRawAxis(xAxisID);

            return createDeadZone(rawInput, xDeadZone);
        }


        private double rawY() {
            final double rawInput = -parent.getRawAxis(yAxisID);

            return createDeadZone(rawInput, yDeadZone);
        }

        private double magnitude(double x, double y) {
            final double xSquared = Math.pow(x, 2);
            final double ySquared = Math.pow(y, 2);

            return Math.sqrt(xSquared + ySquared);
        }

        private double angleToSquareSpace(double angle) {
            final double absAngle = Math.abs(angle);
            final double halfPi = Math.PI / 2;
            final double quarterPi = Math.PI / 4;
            final double modulus = absAngle % halfPi;

            return -Math.abs(modulus - quarterPi) + quarterPi;
        }

        private double scaleMagnitude(double x, double y) {
            final double magnitude = magnitude(x, y);
            final double angle = Math.atan2(x, y);
            final double newAngle = angleToSquareSpace(angle);
            final double scaleFactor = Math.cos(newAngle);

            return magnitude * scaleFactor;
        }

        @Override
        public boolean get() {
            return parent.getRawButton(pressedID);
        }

        public HAND getHand() {
            return hand;
        }

        public double getX() {
            return rawX();
        }

        public double getY() {
            return rawY();
        }

    
        public double getAngle() {
            final double angle = Math.atan2(rawX(), rawY());

            return Math.toDegrees(angle);
        }
/*A number between 0 and 1
         */
        public double getMagnitude() {
            double magnitude = scaleMagnitude(rawX(), rawY());

            if (magnitude > 1) {
                magnitude = 1;
            }

            return magnitude;
        }

        public double getTrueX() {
            final double x = rawX();
            final double y = rawY();
            final double angle = Math.atan2(x, y);

            return scaleMagnitude(x, y) * Math.sin(angle);
        }

        public double getTrueY() {
            final double x = rawX();
            final double y = rawY();
            final double angle = Math.atan2(x, y);

            return scaleMagnitude(x, y) * Math.cos(angle);
        }

        public void setXDeadZone(double number) {
            xDeadZone = number;
        }

        public void setYDeadZone(double number) {
            yDeadZone = number;
        }

        public void setDeadZone(double number) {
            xDeadZone = number;
            yDeadZone = number;
        }
    }


    public static class Trigger extends Button {

        private final Joystick parent;
        private final HAND hand;

        private double deadZone;
        private double sensitivity;

        public Trigger(final Joystick joystick, final HAND hand) {

            this.parent = joystick;
            this.hand = hand;
            this.deadZone = DEFAULT_TRIGGER_DEADZONE;
            this.sensitivity = DEFAULT_TRIGGER_SENSITIVITY;
        }

        /* Extended Methods */
        @Override
        public boolean get() {
            return getX() > sensitivity;
        }

        public HAND getHand() {
            return hand;
        }

        public double getX() {
            final double rawInput;

            if (hand == HAND.LEFT) {
                rawInput = parent.getRawAxis(LEFT_TRIGGER_AXIS_ID);
            } else {
                rawInput = parent.getRawAxis(RIGHT_TRIGGER_AXIS_ID);
            }

            return createDeadZone(rawInput, deadZone);
        }

        public double getY() {
            return getX();
        }

        public void setTriggerDeadZone(double number) {
            this.deadZone = number;
        }

        public void setTriggerSensitivity(double number) {
            this.sensitivity = number;
        }
    }

    public static class DirectionalPad extends Button {


        private final Joystick parent;

        public final Button up;
        public final Button upRight;
        public final Button right;
        public final Button downRight;
        public final Button down;
        public final Button downLeft;
        public final Button left;
        public final Button upLeft;

        public DirectionalPad(final Joystick parent) {

            this.parent = parent;
            this.up = new DPadButton(this, DPAD.UP);
            this.upRight = new DPadButton(this, DPAD.UP_RIGHT);
            this.right = new DPadButton(this, DPAD.RIGHT);
            this.downRight = new DPadButton(this, DPAD.DOWN_RIGHT);
            this.down = new DPadButton(this, DPAD.DOWN);
            this.downLeft = new DPadButton(this, DPAD.DOWN_LEFT);
            this.left = new DPadButton(this, DPAD.LEFT);
            this.upLeft = new DPadButton(this, DPAD.UP_LEFT);
            
        }

        public static class DPadButton extends Button {

            private final DPAD direction;
            private final DirectionalPad parent;

            public DPadButton(final DirectionalPad parent, final DPAD dPadDirection) {

                this.direction = dPadDirection;
                this.parent = parent;
            }

            @Override
            public boolean get() {
                return parent.getAngle() == direction.value;
            }
        }

        private int angle() {
            return parent.getPOV();
            
        }
        @Override
        public boolean get() {
            return angle() != -1;
        }

        public int getAngle() {
            return angle();
        }

        public DPAD getDirection() {
            return DPAD.getEnum(angle());
        }
    }

    private static double createDeadZone(double input, double deadZoneSize) {
        final double negative;
        double deadZoneSizeClamp = deadZoneSize;
        double adjusted;

        if (deadZoneSizeClamp < 0 || deadZoneSizeClamp >= 1) {
            deadZoneSizeClamp = 0;
        }

        negative = input < 0 ? -1 : 1;

        adjusted = Math.abs(input) - deadZoneSizeClamp;
        adjusted = adjusted < 0 ? 0 : adjusted;
        adjusted = adjusted / (1 - deadZoneSizeClamp);

        return negative * adjusted;
    }

    public int getPort() {
        return port;
    }

    public Joystick getJoystick() {
        return controller;
    }

    
    public void setRumble(HAND hand, double intensity) {
        final float amount = new Float(intensity);

        if (hand == HAND.LEFT) {
            controller.setRumble(RumbleType.kLeftRumble, amount);
        } else {
            controller.setRumble(RumbleType.kRightRumble, amount);
        }
    }

    public void setRumble(double intensity) {
        final float amount = new Float(intensity);

        controller.setRumble(RumbleType.kLeftRumble, amount);
        controller.setRumble(RumbleType.kRightRumble, amount);
    }

    public void setDeadZone(double number) {
        leftStick.setDeadZone(number);
        rightStick.setDeadZone(number);
    }
}