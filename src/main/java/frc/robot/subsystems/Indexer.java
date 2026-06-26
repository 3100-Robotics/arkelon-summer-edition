package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import static edu.wpi.first.units.Units.RPM;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import yams.motorcontrollers.SmartMotorController;
import yams.motorcontrollers.local.SparkWrapper;
import yams.motorcontrollers.remote.TalonFXWrapper;

public class Indexer extends SubsystemBase{
    private final SparkMax rawMiddleMotor = new SparkMax(Constants.Indexer.middleMotorID, MotorType.kBrushless);
    private final TalonFX rawBottomMotor = new TalonFX(Constants.Indexer.bottomMotorID);
    private final SparkMax rawTopMotor = new SparkMax(Constants.Indexer.topMotorID, MotorType.kBrushless);

    private final SmartMotorController middleMotor = new SparkWrapper(rawMiddleMotor, DCMotor.getNEO(1), Constants.Indexer.indexerMiddleConfig.clone().withSubsystem(this));
    private final SmartMotorController bottomMotor = new TalonFXWrapper(rawBottomMotor, DCMotor.getKrakenX60(1), Constants.Indexer.indexerBottomConfig.clone().withSubsystem(this));
    private final SmartMotorController topMotor = new SparkWrapper(rawTopMotor, DCMotor.getNEO(1), Constants.Indexer.indexerTopConfig.clone().withSubsystem(this));

    public void setDutyCycle(double bottomDutyCycle, double middleDutyCycle, double topDutyCycle) {
        bottomMotor.setDutyCycle(bottomDutyCycle);
        middleMotor.setDutyCycle(middleDutyCycle);
        topMotor.setDutyCycle(topDutyCycle);
    }

    public void setSpeed(AngularVelocity bottomSpeed, AngularVelocity middleSpeed, AngularVelocity topSpeed) {
        bottomMotor.setVelocity(bottomSpeed);
        middleMotor.setVelocity(middleSpeed);
        topMotor.setVelocity(topSpeed);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("indexerBottomRPM", bottomMotor.getMechanismVelocity().in(RPM));
        bottomMotor.updateTelemetry();
        SmartDashboard.putNumber("indexerMiddleRPM", middleMotor.getMechanismVelocity().in(RPM));
        middleMotor.updateTelemetry();
        SmartDashboard.putNumber("indexerTopRPM", topMotor.getMechanismVelocity().in(RPM));
        topMotor.updateTelemetry();
    }

    @Override
    public void simulationPeriodic() {
        bottomMotor.simIterate();
        middleMotor.simIterate();
        topMotor.simIterate();
    }



}
