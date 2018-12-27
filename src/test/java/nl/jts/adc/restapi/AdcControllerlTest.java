package nl.jts.adc.restapi;

import lombok.extern.slf4j.Slf4j;
import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class AdcControllerlTest {

    @Test
    public void testCreateCommand(){
        final String aHref = "<a class=\"listlink siz_icon siz_ctCON\" href=\"/kenniscentrum-duizeligheid/Sneek/Vietaal-Fysiotherapie.html\" title=\"Alle Sterk, master manueeltherapeut, orofaciaal fysiotherapeut\">Vietaal Fysiotherapie</a>";
        Element tag = Jsoup.parse(aHref, "", Parser.xmlParser())
                           .select("a[href]")
                           .get(0);

        ToevoegenFysiotherapiePraktijkCommand command = AdcController.createToevoegenPraktijkCommand(tag);

        assertThat(command.getNaam()).isEqualTo("Vietaal Fysiotherapie");
        assertThat(command.getWoonplaats()).isEqualTo("Sneek");
        assertThat(command.getHtmlOpPagina()).isEqualTo("Vietaal-Fysiotherapie.html");

    }
}
