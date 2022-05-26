package bvnk.api.controller;

import bvnk.dto.v0.BalanceDto;
import bvnk.service.account.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v0/account/")
public class BankAccountController {
    BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping(path = "get-balance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BalanceDto> getBalance(
            @RequestParam Long bankAccountNumber,
            @RequestHeader Map<String, String> headers
    ) {
        return ResponseEntity.ok(bankAccountService.getBalance(bankAccountNumber));
    }
}
