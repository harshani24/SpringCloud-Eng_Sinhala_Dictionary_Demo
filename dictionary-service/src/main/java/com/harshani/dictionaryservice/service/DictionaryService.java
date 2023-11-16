package com.harshani.dictionaryservice.service;

import com.harshani.dictionaryservice.dto.DictionaryDTO;
import com.harshani.dictionaryservice.model.Dictionary;

import java.util.List;

public interface DictionaryService {

    public List<Dictionary> getDictionaryHistory();

    public List<Dictionary> getDictionaryHistoryByUser(String user);

    public List<String> translateWord(DictionaryDTO dictionaryDTO);
}