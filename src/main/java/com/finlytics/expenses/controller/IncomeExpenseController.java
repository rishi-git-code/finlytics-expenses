package com.finlytics.expenses.controller;

import com.finlytics.expenses.dto.IncomeExpenseReqDTO;
import com.finlytics.expenses.dto.IncomeExpenseResponseDTO;
import com.finlytics.expenses.services.IncomeExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/expense")
@CrossOrigin(origins = "*")
public class IncomeExpenseController {

    @Autowired
    private IncomeExpenseService incomeExpenseService;

    @GetMapping("/demo")
    public ResponseEntity<?> demo(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok("Received user: " + userId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEntry(@RequestBody IncomeExpenseReqDTO incomeExpenseReqDTO,
                                      @RequestHeader("userId") String userId) {

        IncomeExpenseResponseDTO response = incomeExpenseService.addEntry(incomeExpenseReqDTO,userId);
        return ResponseEntity.ok(response);
    }
    @GetMapping("query")
    public  ResponseEntity<?> getEntry(@RequestHeader("userId") String userId){
        return ResponseEntity.ok(incomeExpenseService.getEntriesListForUser(userId));
    }

}
