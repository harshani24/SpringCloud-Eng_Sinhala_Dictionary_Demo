package com.harshani.translationservice.service;

import com.harshani.translationservice.dto.SearchRequestDTO;
import com.harshani.translationservice.dto.TranslationDTO;
import com.harshani.translationservice.model.Translation;
import com.harshani.translationservice.repository.TranslationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranslationServiceImpl implements TranslationService{

    @Autowired
    TranslationRepository translationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Translation createTranslationRecord(TranslationDTO translationDTO) {
        Translation translation = modelMapper.map(translationDTO,Translation.class);

        Optional<Translation> existingTranslation = translationRepository.findByWordAndSourceLanguageAndTargetLanguage(
                translation.getWord(),
                translation.getSourceLanguage(),
                translation.getTargetLanguage()
        );

        if(!
                existingTranslation.isPresent()){
            return translationRepository.save(translation);
        }
        return null;
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