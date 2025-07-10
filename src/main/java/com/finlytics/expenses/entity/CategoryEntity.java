package com.finlytics.expenses.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Category")
public class CategoryEntity {

    @Id
    private String categoryId;

    private String name;
    private String description;
    private List<SubCategoryEntity> subCategoryEntityList;

}
