package com.harshani.dictionaryservice.controller;

import com.harshani.dictionaryservice.dto.DictionaryDTO;
import com.harshani.dictionaryservice.model.Dictionary;
import com.harshani.dictionaryservice.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dictionaries")
public class DictionaryController {

    @Autowired
    DictionaryService dictionaryService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Dictionary> getAllDictionaryHistory(){
        return dictionaryService.getDictionaryHistory();
    }

    @GetMapping("/user/{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<Dictionary> getAllDictionaryHistoryByUser(@PathVariable("username") String user){
        return dictionaryService.getDictionaryHistoryByUser(user);
    }

    @PostMapping("/find")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> translateWord(@RequestBody DictionaryDTO dictionaryDTO){
        return dictionaryService.translateWord(dictionaryDTO);
    }
}

