package nl.jts.adc.coreapi.events;

import lombok.Value;

@Value
public class PraktijkToegevoegdEvent {
    String aggregateId;
    String naam;
    String woonplaats;
    String htlmOpPagina;
}
