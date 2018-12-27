package nl.jts.adc.coreapi.events;

import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Value
public class PraktijkToegevoegdEvent {

    @TargetAggregateIdentifier
    String aggregateId;

    String naam;
    String woonplaats;
    String htlmOpPagina;
}
