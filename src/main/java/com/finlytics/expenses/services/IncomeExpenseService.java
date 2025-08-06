package com.finlytics.expenses.services;

import com.finlytics.expenses.dto.IncomeExpenseReqDTO;
import com.finlytics.expenses.dto.IncomeExpenseResponseDTO;
import com.finlytics.expenses.entity.ExpensesEntity;
import com.finlytics.expenses.entity.UserReference;
import com.finlytics.expenses.repository.ExpenseRepository;
import com.finlytics.expenses.repository.UserReferenceRepository;
import com.finlytics.expenses.utils.ExpenseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncomeExpenseService {

    @Autowired
    private ExpenseRepository repositoty;

    @Autowired
    private UserReferenceRepository userReferenceRepository;

    @Autowired
    private ExpenseUtils expenseUtils;

    public IncomeExpenseResponseDTO addEntry(IncomeExpenseReqDTO incomeExpenseReqDTO, String userId) {

        if (!expenseUtils.isValidUser(userId)) {
            throw new RuntimeException("User not found");
        }
        ExpensesEntity entity = new ExpensesEntity();
        entity.setUserId(userId);
        entity.setType(incomeExpenseReqDTO.getType());

        entity.setAmount(incomeExpenseReqDTO.getAmount());
        entity.setDescription(incomeExpenseReqDTO.getDescription());

        ExpensesEntity savedData = repositoty.save(entity);

        return mapToResponseDTO(savedData);
    }

    private IncomeExpenseResponseDTO mapToResponseDTO(ExpensesEntity savedData) {

        IncomeExpenseResponseDTO responseDTO = new IncomeExpenseResponseDTO();
        responseDTO.setExpenseId(savedData.getExpenseId());
        responseDTO.setType(savedData.getType());

        responseDTO.setAmount(savedData.getAmount());
        responseDTO.setDescription(savedData.getDescription());
        responseDTO.setCreatedAt(savedData.getCreatedAt());
        responseDTO.setUpdatedAt(savedData.getUpdatedAt());

        return responseDTO;
    }

    public List<IncomeExpenseResponseDTO> getEntriesListForUser(String userId) {

        List<IncomeExpenseResponseDTO> expenseList = repositoty.findByUserId(userId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
        System.out.println("Expense List: "+expenseList);
        return expenseList;
    }
}
