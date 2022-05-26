package bvnk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "transaction_entity", uniqueConstraints = {@UniqueConstraint(columnNames = {"uuid"})})
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(updatable = false, nullable = false)
    private BigDecimal amount;
    @Column(updatable = false, nullable = false)
    private BigDecimal baseCurrencyAmount;
    @Column(updatable = false, nullable = false)
    private BigDecimal fee;
    @Column(updatable = false, nullable = false)
    private BigDecimal baseCurrencyFee;
    @Column(updatable = false, nullable = false)
    private String uuid;
    @Column(updatable = false, nullable = false)
    private Long bankAccountId;

    public TransactionEntity(BigDecimal amount, BigDecimal baseCurrencyAmount, BigDecimal fee, BigDecimal baseCurrencyFee, String uuid, Long bankAccountId) {
        this.amount = amount;
        this.baseCurrencyAmount = baseCurrencyAmount;
        this.fee = fee;
        this.baseCurrencyFee = baseCurrencyFee;
        this.uuid = uuid;
        this.bankAccountId = bankAccountId;
    }
}
