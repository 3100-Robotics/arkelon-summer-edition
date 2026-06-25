package frc.robot;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.KilogramMetersPerSecond;
import static edu.wpi.first.units.Units.KilogramMetersSquaredPerSecond;
import static edu.wpi.first.units.Units.KilogramSquareMeters;
import static edu.wpi.first.units.Units.Milliamps;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import yams.motorcontrollers.SmartMotorControllerConfig;
import yams.motorcontrollers.SmartMotorControllerConfig.TelemetryVerbosity;

public class Constants {
    public static class Intake {
        public static int rollerMotorID = 31;

        public static SmartMotorControllerConfig intakeRollerConfig = new SmartMotorControllerConfig()
            .withMotorInverted(false)

            .withStatorCurrentLimit(Amps.of(80))

            .withGearing(36/20)

            .withClosedLoopController(0, 0, 0)
            .withSimClosedLoopController(0.001, 0, 0)

            .withFeedforward(new SimpleMotorFeedforward(0, 0))
            .withSimFeedforward(new SimpleMotorFeedforward(0, 0.1246))

            .withTelemetry("intakeRollerMotor", TelemetryVerbosity.HIGH)

            .withMomentOfInertia(KilogramSquareMeters.of(0.0001))
        ;
    }
}
