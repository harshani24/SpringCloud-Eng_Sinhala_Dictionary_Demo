package com.harshani.dictionaryservice.controller;

import com.harshani.dictionaryservice.dto.DictionaryDTO;
import com.harshani.dictionaryservice.model.Dictionary;
import com.harshani.dictionaryservice.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dictionaries")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping
    public ResponseEntity<List<Dictionary>> getAllDictionaryHistory(){
        List<Dictionary> allDictionaryList = dictionaryService.getDictionaryHistory();
        return new ResponseEntity<>(allDictionaryList, HttpStatus.OK );
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Dictionary>> getAllDictionaryHistoryByUser(@PathVariable("username") String user){
        List<Dictionary> allDictionaryListForUser = dictionaryService.getDictionaryHistoryByUser(user);
        return new ResponseEntity<>(allDictionaryListForUser, HttpStatus.OK );
    }

    @PostMapping("/find")
    public ResponseEntity<List<String>> translateWord(@RequestBody DictionaryDTO dictionaryDTO){
        List<String> translatedWordList = dictionaryService.translateWord(dictionaryDTO);
        return new ResponseEntity<>(translatedWordList, HttpStatus.CREATED);
    }
}

