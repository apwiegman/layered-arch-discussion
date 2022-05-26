package bvnk.repository.repos;

import bvnk.entity.BankAccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<BankAccountEntity, Long> {

    Optional<BankAccountEntity> findByAccountNumber(Long accountNumber);
}
