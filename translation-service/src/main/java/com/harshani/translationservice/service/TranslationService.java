package com.harshani.translationservice.service;

import com.harshani.translationservice.dto.SearchRequestDTO;
import com.harshani.translationservice.dto.TranslationDTO;
import com.harshani.translationservice.model.Translation;

import java.util.List;

public interface TranslationService {
    Translation createTranslationRecord(TranslationDTO translationDTO);

    List<String> findTranslatedWord(SearchRequestDTO searchRequest);
}