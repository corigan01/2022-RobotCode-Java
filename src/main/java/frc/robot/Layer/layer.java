package frc.robot.Layer;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class layer {
    public double forward_drive_speed = 0;
    public double turning_drive_speed = 0;

    public void DisplayVar() {
        SmartDashboard.putNumber("Forward Driving", forward_drive_speed);
        SmartDashboard.putNumber("Turning Driving", turning_drive_speed);
    }

}
