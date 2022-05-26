package bvnk.clients;

import bvnk.clients.kafka.KafkaProducer;
import bvnk.clients.rates.B2C2RatesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ClientHandlerImpl implements ClientHandler
{
    B2C2RatesClient b2C2RatesClient;
    KafkaProducer kafkaProducer;

    @Autowired
    public ClientHandlerImpl(B2C2RatesClient b2C2RatesClient, KafkaProducer kafkaProducer) {
        this.b2C2RatesClient = b2C2RatesClient;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public BigDecimal getExchangeRate(String base, String counter) {
        return b2C2RatesClient.getRate(base, counter);
    }

    @Override
    public void publishEvent(String event, String topic) {

    }
}
