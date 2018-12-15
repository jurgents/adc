package nl.jts.adc.restapi;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class AdcController {

    @Autowired
    private String website;

    // private final String kenniscentrum-duizeligheid

    @GetMapping("/start")
    public String website() throws IOException {
        List<String> result =  Jsoup.connect(website)
                .get()
                .getElementById("sml_list_1")
                .select("a[href]")
                .stream()
                .map(element -> (element.text() + " : " + element.attr("href")))
                .collect(Collectors.toList());

        result.forEach(href -> log.info(href.toString()));
       return "no";
      }
}
