package bvnk.api.controller;

import bvnk.dto.v0.AddTransactionRequestDto;
import bvnk.dto.v0.TransactionDto;
import bvnk.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v0/transact/")
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "add-transaction", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionDto> addTransaction(
            @RequestBody AddTransactionRequestDto addTransactionRequestDto,
            @RequestHeader Map<String, String> headers
    ) {
        return ResponseEntity.ok(transactionService.addTransaction(addTransactionRequestDto));
    }
}
