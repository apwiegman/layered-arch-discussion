package bvnk.clients;

import java.math.BigDecimal;

public interface ClientHandler {

    /**
     * retrieves the latest exchange rate
     * @param base - base currency to convert from
     * @param counter - currency to convert to
     * @return BigDecimal - exchange rate
     */
    BigDecimal getExchangeRate(String base, String counter);

    /**
     * publish an event to a kafka topic
     * @param event
     * @param topic
     */
    void publishEvent(String event, String topic);
}
