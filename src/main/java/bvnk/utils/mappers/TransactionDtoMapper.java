package bvnk.utils.mappers;

import bvnk.dto.v0.TransactionDto;
import bvnk.entity.TransactionEntity;

public class TransactionDtoMapper {

    public static TransactionDto mapAddTransactionDto(TransactionEntity transactionEntity) {
        return new TransactionDto(
              transactionEntity.getAmount().doubleValue(),
              transactionEntity.getBaseCurrencyAmount().doubleValue(),
              transactionEntity.getFee().doubleValue(),
              transactionEntity.getBaseCurrencyFee().doubleValue(),
              transactionEntity.getUuid(),
              transactionEntity.getBankAccountId()
        );
    }
}
