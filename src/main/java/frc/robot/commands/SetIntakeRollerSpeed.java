package frc.robot.commands;

import static edu.wpi.first.units.Units.RPM;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeRoller;

public class SetIntakeRollerSpeed extends Command {

    private final IntakeRoller intakeRoller;
    private final AngularVelocity speed;

    public SetIntakeRollerSpeed(IntakeRoller intakeRoller, AngularVelocity speed) {
        addRequirements(intakeRoller);
        this.intakeRoller = intakeRoller;
        this.speed = speed;
    }

    @Override
    public void initialize() {
       
    }

    @Override
    public void execute() {
        intakeRoller.setSpeed(speed);
        
    }

    @Override
    public void end(boolean interrupted) {
        intakeRoller.setDutyCycle(0);
    }
}
