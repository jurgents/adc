package nl.jts.adc.restapi;

import lombok.extern.slf4j.Slf4j;
import nl.jts.adc.coreapi.commands.ToevoegenFysiotherapiePraktijkCommand;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RestController
public class AdcController {

    @Autowired
    private String website;

    // private final String kenniscentrum-duizeligheid

    @GetMapping("/start")
    public long website() throws IOException {
        return Jsoup.connect(website)
                .get()
                .getElementById("sml_list_1")
                .select("a[href]")
                .stream()
                .map(AdcControllerUtil::transform)
                .count();
      }
}
