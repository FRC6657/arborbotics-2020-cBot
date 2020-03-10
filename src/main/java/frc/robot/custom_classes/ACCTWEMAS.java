package frc.robot.custom_classes;

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
import frc.robot.Constants.DriveConstants;

public class ACCTWEMAS extends Joystick {
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

    /**
     * Andys<p>
     * Controller<p>
     * Code<p>
     * That<p>
     * Wont<p>
     * Ever<p>
     * Make<p>
     * Any<p>
     * Sense<p>
     * 
     * The primary reason this class exists is so we can utilize the d-pad on xbox controller but it works as a fully functioning replacement for WPI's XBoxController Class
     * 
     * @param port The Driverstation port for the controller
     * 
     * @author Andrew Card
     */
    public ACCTWEMAS(int port) {
        super(port);
        mController = new Joystick(port);
    }

    public double getJoystick(Side side, Axis axis) {

        double deadband = DriveConstants.STICK_DEADBAND;

        boolean left = side == Side.LEFT;
        boolean y = axis == Axis.Y;
        // multiplies by -1 if y-axis (inverted normally)
        return handleDeadband((y ? -1 : 1) * mController.getRawAxis((left ? 0 : 4) + (y ? 1 : 0)), deadband);

    }

    public double getTrigger(Side side) {

        double deadband = DriveConstants.TRIGGER_DEADBAND;
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
        return mController.getRawAxis(side == Side.LEFT ? 2 : 3) > DriveConstants.TRIGGER_DEADBAND;
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

    private double handleDeadband(double value, double deadband) {
        return (Math.abs(value) > Math.abs(deadband)) ? value : 0;
    }
}