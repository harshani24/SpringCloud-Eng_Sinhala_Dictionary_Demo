package com.harshani.dictionaryservice.dto;

import lombok.Data;

@Data
public class DictionaryDTO {
    private String userid;
    private String word;
    private String source_language;
    private String target_language;
}