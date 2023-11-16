package com.harshani.translationservice.repository;

import com.harshani.translationservice.model.Translation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TranslationRepository extends MongoRepository<Translation, String> {
    Optional<Translation> findByWordAndSourceLanguageAndTargetLanguage(String word, String sourceLanguage, String targetLanguage);
}

