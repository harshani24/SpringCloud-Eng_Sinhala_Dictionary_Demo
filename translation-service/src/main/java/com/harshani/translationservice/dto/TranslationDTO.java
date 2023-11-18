package com.harshani.translationservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class TranslationDTO {
    private String word;
    private String sourceLanguage;
    private List<String> targetWord;
    private String targetLanguage;
}
