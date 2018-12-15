package nl.jts.adc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AdcConfiguration {

    @Value("${websiteAdc}")
    private String website;

    @Bean
    public String website(){
        log.info(String.format("Website : %s", website));
        return website;
    }
}
