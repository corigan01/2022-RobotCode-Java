package frc.robot.InputDevices;

import edu.wpi.first.wpilibj.XboxController;

public class xbox {
    public XboxController my_controller;
    
    public xbox(int port) {
        my_controller = new XboxController(port);
    }
    
}
