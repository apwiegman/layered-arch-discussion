package bvnk.dto.v0;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceDto {
    @JsonProperty(required = true)
    private Double amount;
    @JsonProperty(required = true)
    private String currency;

    public BalanceDto(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
