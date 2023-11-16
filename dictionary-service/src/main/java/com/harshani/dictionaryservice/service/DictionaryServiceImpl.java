package com.harshani.dictionaryservice.service;

import com.harshani.dictionaryservice.dto.DictionaryDTO;
import com.harshani.dictionaryservice.dto.SearchRequestDTO;
import com.harshani.dictionaryservice.model.Dictionary;
import com.harshani.dictionaryservice.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Autowired
    WebClient.Builder webClientBuilder;


    public List<Dictionary> getDictionaryHistory(){
        return dictionaryRepository.findAll();
    }

    public List<Dictionary> getDictionaryHistoryByUser(String user){
        return dictionaryRepository.findAllByUserid(user);
    }

    public List<String> translateWord(DictionaryDTO dictionaryDTO){

//        SearchRequestDTO searchRequestDTO = SearchRequestDTO.
//                                                builder().
//                                                word(dictionaryDTO.getWord()).
//                                                source_language(dictionaryDTO.getSource_language()).
//                                                target_language(dictionaryDTO.getTarget_language()).build();

        //.uri("http://localhost:8080/api/v1/translations/find")
        Mono<String[]> translatedWordsMono = webClientBuilder.build()
                .post()
                .uri("lb://translation-service/api/v1/translations/find") // Adjust the endpoint based on your translation service API
                .bodyValue(dictionaryDTO)
                .retrieve()
                .bodyToMono(String[].class);

        List<String> translatedWordList = List.of(translatedWordsMono
                .subscribeOn(Schedulers.immediate()) // Handle response asynchronously
                .block());

        Dictionary  searchedRecord =Dictionary.builder().
                userid(dictionaryDTO.getUserid()).
                word(dictionaryDTO.getWord()).
                source_language(dictionaryDTO.getSource_language()).
                target_language(dictionaryDTO.getTarget_language()).
                build();

        dictionaryRepository.save(searchedRecord);

        return translatedWordList;
    }
}