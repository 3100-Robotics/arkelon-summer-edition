package frc.robot;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.KilogramMetersPerSecond;
import static edu.wpi.first.units.Units.KilogramMetersSquaredPerSecond;
import static edu.wpi.first.units.Units.KilogramSquareMeters;
import static edu.wpi.first.units.Units.Milliamps;

import com.revrobotics.spark.config.EncoderConfig;
import com.revrobotics.spark.config.SparkMaxConfig;

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
            
            .withClosedLoopController(0.0002, 0, 0)
            .withSimClosedLoopController(0.001, 0, 0)

            .withFeedforward(new SimpleMotorFeedforward(0, 0.1197))
            .withSimFeedforward(new SimpleMotorFeedforward(0, 0.1246))

            .withTelemetry("intakeRollerMotor", TelemetryVerbosity.HIGH)

            .withMomentOfInertia(KilogramSquareMeters.of(0.0001))

            .withVendorConfig(new SparkMaxConfig().apply(new EncoderConfig().quadratureAverageDepth(2).quadratureMeasurementPeriod(10)))
        ;
    }
    public static class Indexer {
        public static int bottomMotorID = 40;
        public static int middleMotorID = 41;
        public static int topMotorID = 42;

        public static SmartMotorControllerConfig indexerBaseConfig = new SmartMotorControllerConfig()
            .withStatorCurrentLimit(Amps.of(80))
            .withMomentOfInertia(KilogramSquareMeters.of(0.0001));
        public static SmartMotorControllerConfig indexerBottomConfig = indexerBaseConfig.clone()
            .withGearing(24/20.0)
            .withClosedLoopController(0.001, 0, 0)
            .withSimClosedLoopController(0.001, 0, 0)

            .withFeedforward(new SimpleMotorFeedforward(0, 0.1246))
            .withSimFeedforward(new SimpleMotorFeedforward(0, 0.1246))
            
            .withMotorInverted(true);
        public static SmartMotorControllerConfig indexerMiddleConfig = indexerBaseConfig.clone()
            .withGearing(24/20.0)
            .withClosedLoopController(0.001, 0, 0)
            .withSimClosedLoopController(0.001, 0, 0)

            .withFeedforward(new SimpleMotorFeedforward(0, 0.1246))
            .withSimFeedforward(new SimpleMotorFeedforward(0, 0.1246))
            
            .withMotorInverted(false);
        public static SmartMotorControllerConfig indexerTopConfig = indexerBaseConfig.clone()
            .withGearing(24/36.0)
            .withClosedLoopController(0.001, 0, 0)
            .withSimClosedLoopController(0.001, 0, 0)

            .withFeedforward(new SimpleMotorFeedforward(0, 0.1246))
            .withSimFeedforward(new SimpleMotorFeedforward(0, 0.1246))
            
            .withMotorInverted(false);
    }
}
