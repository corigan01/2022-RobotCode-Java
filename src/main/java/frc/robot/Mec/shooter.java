package frc.robot.Mec;

import frc.robot.Layer.*;

public class shooter {

    layer m_layer;
    public shooter(layer Layer) {
        m_layer = Layer;
    }

    public void drive() {
        if (m_layer.shoot) {
            robotbase.shooter.set(1);
            if (robotbase.shooter.getSelectedSensorVelocity(1) > 15000) {
                robotbase.intake.set(1);
            }
        }
        else {
            robotbase.intake.set(0);
            robotbase.shooter.set(0);
        }
    }
    
}
