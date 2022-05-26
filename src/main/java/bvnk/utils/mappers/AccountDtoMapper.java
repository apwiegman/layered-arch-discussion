package bvnk.utils.mappers;

import bvnk.dto.v0.BalanceDto;
import bvnk.dto.v0.BankAccountDto;
import bvnk.dto.v0.ListBankAccountDto;
import bvnk.entity.BankAccountEntity;

import java.util.ArrayList;
import java.util.List;

public class AccountDtoMapper {

    public static BalanceDto mapBalanceDto(BankAccountEntity bankAccountEntity) {
        return new BalanceDto(
                bankAccountEntity.getBalance().doubleValue(),
                bankAccountEntity.getCurrency()
        );
    }

    public static BankAccountDto mapBankAccountDto(BankAccountEntity bankAccountEntity) {
        return new BankAccountDto(
                bankAccountEntity.getAccountNumber(),
                bankAccountEntity.getCurrency(),
                bankAccountEntity.getBalance()
        );
    }

    public static ListBankAccountDto mapListBankAccountDto(Iterable<BankAccountEntity> bankAccountEntities) {
        List<BankAccountDto> bankAccountDtos = new ArrayList<>();
        bankAccountEntities.forEach(
                bankAccountEntity -> {
                    bankAccountDtos.add(
                           mapBankAccountDto(bankAccountEntity)
                    );
                }
        );
        return new ListBankAccountDto(bankAccountDtos);
    }
}
