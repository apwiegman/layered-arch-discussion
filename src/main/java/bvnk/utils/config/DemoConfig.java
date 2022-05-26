package bvnk.utils.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {
    @Value("${base.currency}")
    private String baseCurrency;

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

}
