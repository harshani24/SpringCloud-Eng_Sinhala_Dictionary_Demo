package com.harshani.translationservice.controller;

import com.harshani.translationservice.dto.SearchRequestDTO;
import com.harshani.translationservice.dto.TranslationDTO;
import com.harshani.translationservice.model.Translation;
import com.harshani.translationservice.service.TranslationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/translations")
@Slf4j
public class TranslationController {

    @Autowired
    TranslationService translationService;

    @PostMapping
    public ResponseEntity<Translation> createTranslationRecord(@RequestBody TranslationDTO translationDTO){
        Translation translationRecord =  translationService.createTranslationRecord(translationDTO);
        return new ResponseEntity<>(translationRecord, HttpStatus.CREATED);
    }


    @PostMapping("/find")
    public ResponseEntity<List<String>> findTranslatedWord(@RequestBody SearchRequestDTO searchRequest){
        log.info("Inside the findTranslateWord");
        List<String> translatedWordList = translationService.findTranslatedWord(searchRequest);
        return  new ResponseEntity<>(translatedWordList, HttpStatus.OK);
    }
}


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Translation createTranslationRecord(@RequestBody Translation translation){
//        return translationService.createTranslationRecord(translation);
//    }