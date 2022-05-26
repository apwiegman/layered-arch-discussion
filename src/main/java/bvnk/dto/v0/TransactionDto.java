package bvnk.dto.v0;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

    @JsonProperty(required = true)
    private Double amount;

    @JsonProperty(required = true)
    private Double baseCurrencyAmount;

    @JsonProperty(required = true)
    private Double fee;

    @JsonProperty(required = true)
    private Double baseCurrencyFee;

    @JsonProperty(required = true)
    private String UUID;

    @JsonProperty(required = true)
    private Long accountNumber;

    public TransactionDto(Double amount, Double baseCurrencyAmount, Double fee, Double baseCurrencyFee, String UUID, Long accountNumber) {
        this.amount = amount;
        this.baseCurrencyAmount = baseCurrencyAmount;
        this.fee = fee;
        this.baseCurrencyFee = baseCurrencyFee;
        this.UUID = UUID;
        this.accountNumber = accountNumber;
    }
}
