package nl.jts.adc.praktijken;

import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class Praktijk {

    private String aggregateIdentifier;
    private String naam;
    private String woonplaats;
    private String adres;
    private String htmlSiteADC;

    @CommandHandler
    public Praktijk on(ToevoegenFysiotherapiePraktijkCommand command){
        String id = UUID.randomUUID().toString();
        //AggregateLifecycle.apply();
        return null;

    }
}
