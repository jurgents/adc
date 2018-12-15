package nl.jts.adc.restapi;

import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import org.jsoup.nodes.Element;

public class AdcControllerUtil {

    public static ToevoegenFysiotherapiePraktijkCommand transform(Element element) {
        String url = element.attr("href");
        String[] parts = url.split("/");
        if (parts.length == 4) {
            return new ToevoegenFysiotherapiePraktijkCommand(element.text(), parts[2], parts[3]);
        } else {
            return new ToevoegenFysiotherapiePraktijkCommand("1", "2", "3");
        }
    }
}