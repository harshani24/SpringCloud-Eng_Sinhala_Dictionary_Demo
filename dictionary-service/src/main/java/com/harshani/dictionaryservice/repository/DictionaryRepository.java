package com.harshani.dictionaryservice.repository;

import com.harshani.dictionaryservice.model.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    List<Dictionary> findAllByUserid(String user);
}