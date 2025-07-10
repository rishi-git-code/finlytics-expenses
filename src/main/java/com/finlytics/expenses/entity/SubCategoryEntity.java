package com.finlytics.expenses.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "sub-category")
public class SubCategoryEntity {

    @Id
    private String subCatId;

    private String name;
    private String description;

}
