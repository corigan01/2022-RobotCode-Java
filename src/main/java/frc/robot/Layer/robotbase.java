package frc.robot.Layer;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.*;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class robotbase {
    public static WPI_TalonFX leftFront = new WPI_TalonFX(2);
    public static WPI_TalonFX leftBack = new WPI_TalonFX(4);
    public static WPI_TalonFX rightFront = new WPI_TalonFX(8);
    public static WPI_TalonFX rightBack = new WPI_TalonFX(6);

    public static MotorControllerGroup left = new MotorControllerGroup(leftFront, leftBack);
    public static MotorControllerGroup right = new MotorControllerGroup(rightFront, rightBack);
    
    public static WPI_TalonFX intake = new WPI_TalonFX(15);
    public static WPI_TalonFX shooter = new WPI_TalonFX(5);
}
