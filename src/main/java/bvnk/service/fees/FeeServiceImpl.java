package bvnk.service.fees;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FeeServiceImpl implements FeeService {
    @Override
    public BigDecimal calculateFee(String currency, BigDecimal amount) {
        // some very complicated fee calculate goes here
        return BigDecimal.valueOf(0.01);
    }
}
