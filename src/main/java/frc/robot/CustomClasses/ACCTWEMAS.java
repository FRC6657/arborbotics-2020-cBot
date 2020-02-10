package frc.robot.CustomClasses;

//Andys
//Controller
//Code
//That
//Wont
//Ever
//Make
//Any
//Sense

/* Imports */
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

public class ACCTWEMAS extends Joystick{
    private final Joystick mController;

    public enum Side {
        LEFT, RIGHT
    }

    public enum Axis {
        X, Y
    }

    public enum Button {
        A(1), B(2), X(3), Y(4), LB(5), RB(6), BACK(7), START(8), L_JOYSTICK(9), R_JOYSTICK(10);

        public final int id;

        Button(int id) {
            this.id = id;
        }
    }

    public ACCTWEMAS(int port) {
        super(port);
        mController = new Joystick(port);
    }

    public double getJoystick(Side side, Axis axis) {

        double deadband = Constants.stickDeadband;

        boolean left = side == Side.LEFT;
        boolean y = axis == Axis.Y;
        // multiplies by -1 if y-axis (inverted normally)
        return handleDeadband((y ? -1 : 1) * mController.getRawAxis((left ? 0 : 4) + (y ? 1 : 0)), deadband);

    }

    public double getTrigger(Side side) {

        double deadband = Constants.triggerDeadband;
        Side Side = side;

        if (Side == ACCTWEMAS.Side.LEFT) {
            return handleDeadband(mController.getRawAxis(3), deadband);
        }
        if (Side == ACCTWEMAS.Side.RIGHT) {

            return handleDeadband(mController.getRawAxis(2), deadband);
        }
        return 0;
    }

    public boolean getTriggerPressed(Side side) {
        return mController.getRawAxis(side == Side.LEFT ? 2 : 3) > Constants.triggerDeadband;
    }

    public boolean getButton(Button button) {
        return mController.getRawButton(button.id);
    }

    public int getDPad() {
        return mController.getPOV();
    }

    public void setRumble(boolean on) {
        mController.setRumble(RumbleType.kRightRumble, on ? 1 : 0);
    }

    private static double handleDeadband(double value, double deadband) {
        return (Math.abs(value) > Math.abs(deadband)) ? value : 0;
    }

    
}