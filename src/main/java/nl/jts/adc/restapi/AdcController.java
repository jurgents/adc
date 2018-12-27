package nl.jts.adc.restapi;

import lombok.extern.slf4j.Slf4j;
import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@Slf4j
@RestController
public class AdcController {

    @Autowired
    private String website;

    @Autowired
    private CommandGateway commandGateway;


    @GetMapping("/start")
    public String website() throws IOException {
        final Stream<Element> linksWithPraktijk = getLinksWithPraktijk(website);
        linksWithPraktijk.forEach(element -> commandGateway.send(createToevoegenPraktijkCommand(element)));
        return "OK";
    }

    private Stream<Element> getLinksWithPraktijk(String site) throws IOException {
        return Jsoup.connect(site)
                .get()
                .getElementById("sml_list_1")
                .select("a[href]")
                .stream()
                .filter(element -> element.text().length() > 1);
    }

    protected static ToevoegenFysiotherapiePraktijkCommand createToevoegenPraktijkCommand(Element element) {
        String[] attributes = element.attr("href").split("/");
        return new ToevoegenFysiotherapiePraktijkCommand(UUID.randomUUID().toString(),
                                                         element.text(),
                                                         attributes[2],
                                                         attributes[3]);
    }
}

