package bvnk.dto.v0;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankAccountDto {
    @JsonProperty(required = true)
    private Long accountNumber;
    @JsonProperty(required = true)
    private String currency;
    @JsonProperty(required = true)
    private BigDecimal balance;

    public BankAccountDto(Long accountNumber, String currency, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = balance;
    }
}
