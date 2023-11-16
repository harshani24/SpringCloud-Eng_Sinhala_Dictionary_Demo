package com.harshani.translationservice.dto;

import lombok.Data;

@Data
public class TranslationDTO {
    private String word;
    private String source_language;
    private String target_word;
    private String target_language;
}
