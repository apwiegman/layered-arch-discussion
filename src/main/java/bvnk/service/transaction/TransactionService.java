package bvnk.service.transaction;

import bvnk.dto.v0.AddTransactionRequestDto;
import bvnk.dto.v0.TransactionDto;

public interface TransactionService {

    /**
     * creates a ledger transaction and updates the bank account balance
     *
     * @param addTransactionRequestDto
     *
     * @return SendTransactionResponse
     */
    TransactionDto addTransaction(AddTransactionRequestDto addTransactionRequestDto);
}
