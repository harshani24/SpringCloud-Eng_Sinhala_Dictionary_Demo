package com.harshani.translationservice.service;

import com.harshani.translationservice.dto.SearchRequestDTO;
import com.harshani.translationservice.model.Translation;
import com.harshani.translationservice.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TranslationServiceImpl implements TranslationService{

    @Autowired
    TranslationRepository translationRepository;

    @Override
    public Translation createTranslationRecord(Translation translation) {
        return translationRepository.save(translation);
    }

    @Override
    public List<String> findTranslatedWord(SearchRequestDTO searchRequest) {
        Optional<Translation> translatedResult =  translationRepository.findByWordAndSourceLanguageAndTargetLanguage(
                searchRequest.getWord(),
                searchRequest.getSource_language(),
                searchRequest.getTarget_language()
        );

        return translatedResult.get().getTargetWord();
    }
}