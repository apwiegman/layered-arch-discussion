package bvnk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction_entity", uniqueConstraints = {@UniqueConstraint(columnNames = {"account_number"})})
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(updatable = false, nullable = false)
    private Long id;
    @Column(name = "account_number", updatable = false, nullable = false)
    private Long accountNumber;
    @Column(updatable = false, nullable = false)
    private String currency;
    @Column(nullable = false)
    private BigDecimal balance;

    public BankAccountEntity(Long accountNumber, BigDecimal balance, String currency) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }
}
