package com.harshani.translationservice.service;

import com.harshani.translationservice.dto.SearchRequestDTO;
import com.harshani.translationservice.model.Translation;

import java.util.List;

public interface TranslationService {
    Translation createTranslationRecord(Translation translation);

    List<String> findTranslatedWord(SearchRequestDTO searchRequest);
}