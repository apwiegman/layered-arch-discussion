package bvnk.service.transaction;

import bvnk.clients.ClientHandler;
import bvnk.dto.v0.AddTransactionRequestDto;
import bvnk.dto.v0.TransactionDto;
import bvnk.entity.BankAccountEntity;
import bvnk.entity.TransactionEntity;
import bvnk.repository.Repository;
import bvnk.service.fees.FeeService;
import bvnk.utils.config.DemoConfig;
import bvnk.utils.mappers.TransactionDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    Repository repository;
    ClientHandler clientHandler;
    DemoConfig demoAppConfig;
    FeeService feeService;


    @Autowired
    public TransactionServiceImpl(Repository repository, ClientHandler clientHandler, DemoConfig demoAppConfig, FeeService feeService) {
        this.repository = repository;
        this.clientHandler = clientHandler;
        this.demoAppConfig = demoAppConfig;
        this.feeService = feeService;
    }

    @Override
    public TransactionDto addTransaction(AddTransactionRequestDto addTransactionRequestDto) {
        // Step 1: get the bank account
        BankAccountEntity bankAccountEntity = repository.getBankAccountEntity(addTransactionRequestDto.getAccountNumber());
        // Step 2: calculate transaction fee
        BigDecimal fee = feeService.calculateFee(bankAccountEntity.getCurrency(), BigDecimal.valueOf(addTransactionRequestDto.getAmount()));
        // Step 3: get exchange rate and calculate base fee and base amount
        BigDecimal exchangeRate = clientHandler.getExchangeRate(demoAppConfig.getBaseCurrency(), bankAccountEntity.getCurrency());
        // Step 4: ledger movements
        TransactionEntity transactionRequest = new TransactionEntity(
                BigDecimal.valueOf(addTransactionRequestDto.getAmount()),
                exchangeRate.multiply(BigDecimal.valueOf(addTransactionRequestDto.getAmount())),
                fee,
                exchangeRate.multiply(fee),
                UUID.randomUUID().toString(),
                bankAccountEntity.getId()
        );
        TransactionEntity transactionEntity = addLedgerTransaction(bankAccountEntity, transactionRequest);
        // Step 4: map and respond
        return TransactionDtoMapper.mapAddTransactionDto(transactionEntity);
    }

    @Transactional
    private TransactionEntity addLedgerTransaction(BankAccountEntity bankAccountEntity, TransactionEntity transactionEntity) {
        // update bank account balance
        BigDecimal updatedBalance = bankAccountEntity.getBalance().add(transactionEntity.getAmount());
        bankAccountEntity.setBalance(updatedBalance);
        repository.persist(bankAccountEntity);
        // add transaction
        return repository.persist(transactionEntity);
    }
}
