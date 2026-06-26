package frc.robot.commands;

import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;

public class SetIndexerBack extends Command {

    private final Indexer indexer;
    private final AngularVelocity bottomSpeed;
    private final AngularVelocity middleSpeed;
    private final AngularVelocity topSpeed;

    public SetIndexerBack(Indexer indexer, AngularVelocity bottomSpeed, AngularVelocity middleSpeed, AngularVelocity topSpeed) {
        addRequirements(indexer);
        this.indexer = indexer;
        this.bottomSpeed = bottomSpeed;
        this.middleSpeed = middleSpeed;
        this.topSpeed = topSpeed;
    }
    
    @Override
    public void initialize() {
       
    }

    @Override
    public void execute() {
        indexer.setSpeed(bottomSpeed.unaryMinus(), middleSpeed.unaryMinus(), topSpeed.unaryMinus());
        
    }

    @Override
    public void end(boolean interrupted) {
        indexer.setDutyCycle(0, 0, 0);
    }
}
