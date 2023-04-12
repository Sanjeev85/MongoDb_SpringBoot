package com.example.mongodb.restcontroller;

import com.example.mongodb.models.Expense;
import com.example.mongodb.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense) {
        System.out.println("add Expense------------------");
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense) {
        System.out.println("put mapping --------------");
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }


    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense() {
        System.out.println("inside get mapping ----------------------");
        return ResponseEntity.ok(expenseService.getAllExpense());
    }


    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name) {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
