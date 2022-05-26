package bvnk.scheduler;

import bvnk.dto.v0.ListBankAccountDto;
import bvnk.service.account.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduler {

    private final BankAccountService bankAccountService;

    @Autowired
    public DemoScheduler(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    /**
     * get and print the balance for each account
     */
    @Scheduled(cron = "${schedule.account.balance}")
    public void scheduleAccountBalanceLogging() {
        try {
            ListBankAccountDto listBankAccountDto = bankAccountService.getBankAccounts();
            listBankAccountDto.getBankAccounts().forEach(
                    bankAccountDto -> System.out.println("The balance for " + bankAccountDto.getAccountNumber() + " is " + bankAccountDto.getBalance())
            );
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
