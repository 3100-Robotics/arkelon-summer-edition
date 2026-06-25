package frc.robot.commands;

import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeRoller;

public class SetIntakeRoller extends Command {

    private final IntakeRoller intakeRoller;
    private final double dutyCycle;

    public SetIntakeRoller(IntakeRoller intakeRoller, double dutyCycle) {
        addRequirements(intakeRoller);
        this.intakeRoller = intakeRoller;
        this.dutyCycle = dutyCycle;
    }

    @Override
    public void initialize() {
       
    }

    @Override
    public void execute() {
        intakeRoller.setDutyCycle(dutyCycle);
        
    }

    @Override
    public void end(boolean interrupted) {
        intakeRoller.setDutyCycle(0);

}}
