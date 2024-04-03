package com.harshani.translationservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "translation_word_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Translation {
    @Id
    private String id;

    private String word;
    private String sourceLanguage;
    private List<String> targetWord;
    private String targetLanguage;
}