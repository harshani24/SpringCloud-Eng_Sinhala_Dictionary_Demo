package com.harshani.dictionaryservice.controller;

import com.harshani.dictionaryservice.dto.DictionaryDTO;
import com.harshani.dictionaryservice.model.Dictionary;
import com.harshani.dictionaryservice.service.DictionaryService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/dictionaries")
@Slf4j
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
    @CircuitBreaker(name="translation", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name="translation", fallbackMethod = "fallbackMethodTimeOut")
    @Retry(name = "translation", fallbackMethod = "fallbackMethodRetryFailure")
    public CompletableFuture<ResponseEntity<List<String>>> translateWord(@RequestBody DictionaryDTO dictionaryDTO){
      log.info("Find the translated word");
       return CompletableFuture.supplyAsync(() -> {
            try{
                List<String> translatedWordList = dictionaryService.translateWord(dictionaryDTO);
                return new ResponseEntity<>(translatedWordList, HttpStatus.CREATED);
            }
            catch(Exception e){
                throw new RuntimeException("Translation failed", e);
            }
        });
    }

    public CompletableFuture<ResponseEntity<String>> fallbackMethod(DictionaryDTO dictionaryDTO , Throwable throwable){
        return CompletableFuture.supplyAsync(() -> {
            return  new ResponseEntity<>("Server may down!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        });
    }

    public CompletableFuture<ResponseEntity<String>> fallbackMethodTimeOut(DictionaryDTO dictionaryDTO , Throwable throwable){
        return CompletableFuture.supplyAsync(() -> {
            return  new ResponseEntity<>("Time Out. Network Slow Performance!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        });
    }

    public CompletableFuture<ResponseEntity<String>> fallbackMethodRetryFailure(DictionaryDTO dictionaryDTO , Throwable throwable){
        return CompletableFuture.supplyAsync(() -> {
            return  new ResponseEntity<>("All Retries are failed!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        });
    }

}

