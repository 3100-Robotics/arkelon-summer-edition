package frc.robot.subsystems;

import static edu.wpi.first.units.Units.RPM;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import yams.motorcontrollers.SmartMotorController;
import yams.motorcontrollers.local.SparkWrapper;

public class IntakeRoller extends SubsystemBase {
    private final SparkMax rawMotor = new SparkMax(Constants.Intake.rollerMotorID, MotorType.kBrushless);
    private final SmartMotorController motor = new SparkWrapper(rawMotor, DCMotor.getNEO(1), Constants.Intake.intakeRollerConfig.clone().withSubsystem(this));

    public void setDutyCycle(double dutyCycle) {
        motor.setDutyCycle(dutyCycle);
    }

    public void setSpeed(AngularVelocity speed) {
        motor.setVelocity(speed);
    }

    @Override
    public void periodic() {
       SmartDashboard.putNumber("intakeRollerRPM", motor.getMechanismVelocity().in(RPM));
       motor.updateTelemetry();
    }
    @Override
    public void simulationPeriodic() {
        motor.simIterate();
    }

}
