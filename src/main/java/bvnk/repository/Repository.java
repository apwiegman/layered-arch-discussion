package bvnk.repository;

import bvnk.entity.BankAccountEntity;
import bvnk.entity.TransactionEntity;
import bvnk.repository.repos.AccountRepository;
import bvnk.repository.repos.TransactionRepository;
import bvnk.utils.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class Repository {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public Repository(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public BankAccountEntity persist(BankAccountEntity bankAccountEntity) {
        return accountRepository.save(bankAccountEntity);
    }

    public TransactionEntity persist(TransactionEntity transactionEntity) {
        return transactionRepository.save(transactionEntity);
    }

    public BankAccountEntity getBankAccountEntity(Long bankAccountNumber) {
        Optional<BankAccountEntity> optionalBankAccountEntity = accountRepository.findByAccountNumber(bankAccountNumber);
        if (optionalBankAccountEntity.isPresent()) {
            return optionalBankAccountEntity.get();
        }
        throw new EntityNotFoundException("Could not find bank account with account number " + bankAccountNumber, 1);
    }

    public Iterable<BankAccountEntity> listBankAccountEntities() {
        return accountRepository.findAll();
    }
}
