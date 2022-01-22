package frc.robot.Layer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class layer {

    /* The vars that layer contains */
    public double forward_drive_speed = 0;
    public double turning_drive_speed = 0;

    public boolean shoot = false;


    // robot mode
    public class mode {
        public static final int DISABLED = 0;
        public static final int TELEOP = 1;
        public static final int AUTO = 2;
        public static final int TEST = 3;
    }

    /* 0 = disabled, 1 = teleop, 2 = auto, 3 = test*/
    private int robot_mode = 0;

    // Display all the vars layer contains
    public void DisplayVar() {
        SmartDashboard.putNumber("Forward Driving", forward_drive_speed);
        SmartDashboard.putNumber("Turning Driving", turning_drive_speed);
        SmartDashboard.putBoolean("Shooting", shoot);

        SmartDashboard.putBoolean("ROBOT PROTECTION ON", false);

        if (robot_mode == mode.DISABLED) SmartDashboard.putString("Robot Mode", "DISABLED");
        if (robot_mode == mode.TELEOP) SmartDashboard.putString("Robot Mode", "TELEOP");
        if (robot_mode == mode.AUTO) SmartDashboard.putString("Robot Mode", "AUTO");
        if (robot_mode == mode.TEST) SmartDashboard.putString("Robot Mode", "TEST");
    }

    // Reset all Vars
    public void resetALL() {
        shoot = false;
        forward_drive_speed = 0;
        turning_drive_speed = 0;

        DisplayVar();
    }

    // Keep the robot from killing anyone
    public void ProtectUser() {

        // These vars needs to be kept at 0 to protect the user
        forward_drive_speed = 0;
        turning_drive_speed = 0;
        shoot = false;

        robot_mode = mode.DISABLED;

        DisplayVar();
        SmartDashboard.putBoolean("ROBOT PROTECTION ON", true);
    }

    public void SetRobotMode(int mode) {
        robot_mode = mode;
    }
}
