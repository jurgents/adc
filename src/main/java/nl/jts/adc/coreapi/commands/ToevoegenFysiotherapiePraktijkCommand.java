package nl.jts.adc.coreapi.commands;

import lombok.Value;

@Value
public class ToevoegenFysiotherapiePraktijkCommand {
    String id;

    String naam;
    String woonplaats;
    String htmlOpPagina;
}
