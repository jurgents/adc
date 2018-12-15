package nl.jts.adc.coreapi.commands;

import lombok.Value;

@Value
public class ToevoegenFysiotherapiePraktijkCommand {
    String naam;
    String woonplaats;
    String htmlOpPagina;
}
