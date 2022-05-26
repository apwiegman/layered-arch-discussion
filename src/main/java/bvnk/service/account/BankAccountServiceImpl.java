package bvnk.service.account;

import bvnk.dto.v0.BalanceDto;
import bvnk.dto.v0.ListBankAccountDto;
import bvnk.entity.BankAccountEntity;
import bvnk.repository.Repository;
import bvnk.utils.mappers.AccountDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final Repository repository;

    @Autowired
    public BankAccountServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public BalanceDto getBalance(Long accountNumber) {
        BankAccountEntity bankAccountEntity = repository.getBankAccountEntity(accountNumber);
        return AccountDtoMapper.mapBalanceDto(bankAccountEntity);
    }

    @Override
    public ListBankAccountDto getBankAccounts() {
        Iterable<BankAccountEntity> bankAccountEntities = repository.listBankAccountEntities();
        return AccountDtoMapper.mapListBankAccountDto(bankAccountEntities);
    }
}
