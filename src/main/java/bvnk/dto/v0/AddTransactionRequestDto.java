package bvnk.dto.v0;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTransactionRequestDto {

    @JsonProperty(required = true)
    private Double amount;

    @JsonProperty(required = true)
    private Long accountNumber;

    public AddTransactionRequestDto(Double amount, Long accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }
}
