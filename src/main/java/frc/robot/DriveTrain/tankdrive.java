package frc.robot.DriveTrain;

import frc.robot.Layer.robotbase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Layer.layer;

public class tankdrive {
    
    private layer my_control;
    private DifferentialDrive my_drive;

    public tankdrive(layer input_control) {
        my_control = input_control;
        my_drive = new DifferentialDrive(robotbase.left, robotbase.right);
    }

    public void drive() {
        motor_drive(my_control.forward_drive_speed, my_control.turning_drive_speed);
    }

    private void motor_drive(double forward, double turn) {
        my_drive.arcadeDrive(forward, turn);
        
        //System.out.println("Forward Speed: " + forward + ", Turning Speed: " + turn);
    
    }
}
