package nl.jts.adc.fysiotherapie;

import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import nl.jts.adc.coreapi.events.PraktijkToegevoegdEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class PraktijkTest {

    public static final String PRAKTIJK_WOONPLAATS = "Ergens";
    public static final String PRAKTIJK_NAAM = "FenF";
    public static final String PRAKTIJK_HTML = "<iets moeijlijks/>";

    private FixtureConfiguration<Praktijk> fixture;

    @Before
    public void init(){
        fixture = new AggregateTestFixture<>(Praktijk.class);
    }

    @Test
    public void test_toevoegen_praktijk(){
        final String aggregateIdPraktijk = UUID.randomUUID().toString();
        fixture.givenNoPriorActivity()
               .when(new ToevoegenFysiotherapiePraktijkCommand(aggregateIdPraktijk, PRAKTIJK_NAAM, PRAKTIJK_WOONPLAATS, PRAKTIJK_HTML))
               .expectEvents(new PraktijkToegevoegdEvent(aggregateIdPraktijk, PRAKTIJK_NAAM, PRAKTIJK_WOONPLAATS, PRAKTIJK_HTML));
    }

}
