package bvnk.dto.v0;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListBankAccountDto {
    private List<BankAccountDto> bankAccounts;

    public ListBankAccountDto(List<BankAccountDto> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
