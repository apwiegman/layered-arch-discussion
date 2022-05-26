package bvnk.clients.rates;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class B2C2RatesClient {
    public BigDecimal getRate(String from, String to) {
        return BigDecimal.TEN;
    }
}
