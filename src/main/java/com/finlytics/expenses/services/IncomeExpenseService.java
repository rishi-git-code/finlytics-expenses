package com.finlytics.expenses.services;

import com.finlytics.expenses.dto.IncomeExpenseReqDTO;
import com.finlytics.expenses.dto.IncomeExpenseResponseDTO;
import com.finlytics.expenses.entity.IncomeExpensesEntity;
import com.finlytics.expenses.repository.IncomeExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeExpenseService {

    @Autowired
    private IncomeExpenseRepository repositoty;

    public IncomeExpenseResponseDTO addEntry(IncomeExpenseReqDTO incomeExpenseReqDTO, String userId) {
        IncomeExpensesEntity entity = new IncomeExpensesEntity();
        entity.setUserId(userId);
        entity.setType(incomeExpenseReqDTO.getType());
        entity.setCategory(incomeExpenseReqDTO.getCategory());
        entity.setAmount(incomeExpenseReqDTO.getAmount());
        entity.setDescription(incomeExpenseReqDTO.getDescription());

        IncomeExpensesEntity savedData = repositoty.save(entity);

        return mapToResponseDTO(savedData);
    }

    private IncomeExpenseResponseDTO mapToResponseDTO(IncomeExpensesEntity savedData) {

        IncomeExpenseResponseDTO responseDTO = new IncomeExpenseResponseDTO();
        responseDTO.setId(savedData.getId());
        responseDTO.setType(savedData.getType());
        responseDTO.setCategory(savedData.getCategory());
        responseDTO.setAmount(savedData.getAmount());
        responseDTO.setDescription(savedData.getDescription());
        responseDTO.setCreatedAt(savedData.getCreatedAt());
        responseDTO.setUpdatedAt(savedData.getUpdatedAt());

        return responseDTO;
    }

    public List<IncomeExpenseResponseDTO> getEntriesListForUser(String userId) {
        return repositoty.findByUserId(userId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }
}
