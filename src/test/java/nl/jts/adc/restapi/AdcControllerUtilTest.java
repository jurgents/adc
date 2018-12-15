package nl.jts.adc.restapi;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.junit.Test;

@Slf4j
public class AdcControllerUtilTest {

    @Test
    public void testTransform(){
        final String aHref = "<a class=\"listlink siz_icon siz_ctCON\" href=\"/kenniscentrum-duizeligheid/Sneek/Vietaal-Fysiotherapie.html\" title=\"Alle Sterk, master manueeltherapeut, orofaciaal fysiotherapeut\">Vietaal Fysiotherapie</a>";
        Element tag = Jsoup.parse(aHref, "", Parser.xmlParser())
                           .select("a[href]")
                           .get(0);
        log.info(tag.text());
        log.info(tag.attr("href"));
    }
}
