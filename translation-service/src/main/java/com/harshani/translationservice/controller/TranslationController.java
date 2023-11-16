package com.harshani.translationservice.controller;

import com.harshani.translationservice.dto.SearchRequestDTO;
import com.harshani.translationservice.model.Translation;
import com.harshani.translationservice.service.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/translations")
@Slf4j
public class TranslationController {

    @Autowired
    TranslationService translationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Translation createTranslationRecord(@RequestBody Translation translation){
        return translationService.createTranslationRecord(translation);
    }

    @PostMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<String> findTranslatedWord(@RequestBody SearchRequestDTO searchRequest){
        log.info("Inside the findTranslateWord");
        return translationService.findTranslatedWord(searchRequest);
    }
}