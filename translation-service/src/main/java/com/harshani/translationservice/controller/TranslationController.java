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
import java.util.concurrent.TimeoutException;

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
    public ResponseEntity<List<String>> findTranslatedWord(@RequestBody SearchRequestDTO searchRequest) throws TimeoutException {
        log.info("Wait Started");
        // Simulate slow network behavior
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status as true
            throw new TimeoutException("Operation timed out");
        }
        log.info("Wait Ended");

        List<String> translatedWordList = translationService.findTranslatedWord(searchRequest);
        return  new ResponseEntity<>(translatedWordList, HttpStatus.OK);
    }
}


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Translation createTranslationRecord(@RequestBody Translation translation){
//        return translationService.createTranslationRecord(translation);
//    }