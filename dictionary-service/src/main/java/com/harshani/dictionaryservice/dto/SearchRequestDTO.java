package com.harshani.dictionaryservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchRequestDTO {
    private String word;
    private String source_language;
    private String target_language;
}