package bvnk.service.fees;

import java.math.BigDecimal;

public interface FeeService {

    /**
     * calculate the fee to charge for a transaction
     *
     * @param currency - transaction currency
     * @param amount - transaction amount
     * @return BigDecimal fee amount
     */
    BigDecimal calculateFee(String currency, BigDecimal amount);
}
