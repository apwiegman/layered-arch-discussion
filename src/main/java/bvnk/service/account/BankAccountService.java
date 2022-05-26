package bvnk.service.account;

import bvnk.dto.v0.BalanceDto;
import bvnk.dto.v0.ListBankAccountDto;

import java.lang.reflect.AccessibleObject;

public interface BankAccountService {
    /**
     * get the balance for a bank account
     *
     * @param accountNumber - bank account number that appears on statement
     *
     *
     */
    BalanceDto getBalance(Long accountNumber);

    /**
     * get a list of all the bank accounts
     *
     * @return ListBankAccountDto
     */
    ListBankAccountDto getBankAccounts();
}
