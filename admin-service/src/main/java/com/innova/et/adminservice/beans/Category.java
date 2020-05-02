package com.innova.et.adminservice.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Set;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category implements Serializable {

    private String id;
    @Indexed(unique = true)
    private String name;
    private Set<String> children;

    public Category(String name) {
        this.name = name;
    }
}
