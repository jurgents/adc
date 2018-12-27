package nl.jts.adc.fysiotherapie;

import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import nl.jts.adc.coreapi.events.PraktijkToegevoegdEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Praktijk {

    @AggregateIdentifier
    private String aggregateIdentifier;

    private String naam;
    private String woonplaats;
    private String adres;
    private String htmlSiteADC;

    protected Praktijk(){
    }

    @CommandHandler
    public Praktijk (ToevoegenFysiotherapiePraktijkCommand command){
        AggregateLifecycle.apply(new PraktijkToegevoegdEvent(command.getId(),
                                                             command.getNaam(),
                                                             command.getWoonplaats(),
                                                             command.getHtmlOpPagina()));
    }

    @EventSourcingHandler
    public void on(PraktijkToegevoegdEvent event){
        aggregateIdentifier = event.getAggregateId();
        naam = event.getNaam();
        woonplaats = event.getWoonplaats();
        htmlSiteADC = event.getHtlmOpPagina();
    }
}
