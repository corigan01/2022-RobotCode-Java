package frc.robot.InputDevices;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Layer.*;

public class xbox {
    public XboxController my_controller;
    public layer my_layer;

    public xbox(int port, layer layer) {
        my_controller = new XboxController(port);
    }

    public void OutputIntoLayer() {
        my_layer.forward_drive_speed = my_controller.getRightX();
        my_layer.turning_drive_speed = -my_controller.getLeftY();

        my_layer.shoot = my_controller.getAButton();
    }
    
}
