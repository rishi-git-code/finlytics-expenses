package com.finlytics.expenses.services;

import com.finlytics.expenses.dto.BudgetReqDTO;
import com.finlytics.expenses.dto.BudgetResDTO;
import com.finlytics.expenses.entity.BudgetEntity;
import com.finlytics.expenses.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<BudgetResDTO> createBudget(BudgetReqDTO reqDTO, String userId) {
        BudgetEntity budget = new BudgetEntity();
        budget.setUserId(userId);
        budget.setName(reqDTO.getName());

        budget.setAmount(reqDTO.getAmount());
        budget.setCurrency(reqDTO.getCurrency());

        BudgetEntity record = budgetRepository.save(budget);

        return mapToResponse(record);
    }

    private List<BudgetResDTO> mapToResponse(BudgetEntity record) {
        List<BudgetResDTO> budgetResList = new ArrayList<BudgetResDTO>();
        BudgetResDTO budgetResDTO = new BudgetResDTO();
        budgetResDTO.setBudgetId(record.getBudgetId());
        budgetResDTO.setName(record.getName());
        budgetResDTO.setAmount(record.getAmount());
        budgetResDTO.setCurrency(record.getCurrency());
        budgetResList.add(budgetResDTO);
        return budgetResList;
    }
}
