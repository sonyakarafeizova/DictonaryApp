package com.dictionaryapp.service;

import com.dictionaryapp.config.UserSession;
import com.dictionaryapp.model.dto.AddWordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WordsService {

    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final UserSession userSession;
    private final WordRepository wordRepository;

    public WordsService(LanguageRepository languageRepository, UserRepository userRepository, UserSession userSession, WordRepository wordRepository) {
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.userSession = userSession;
        this.wordRepository = wordRepository;
    }

    public void add(AddWordDTO data) {
        Word word = new Word();

        // TODO: Save and attach correct user + language
    }

    public List<Word> findSpanish() {
        Optional<User> user = userRepository.findById(userSession.userId());

        if (user.isEmpty()) {
            return new ArrayList<>();
        }

        Language language = languageRepository.findByLanguageName(LanguageEnum.SPANISH);

        return wordRepository.findByLanguageAndAddedBy(language, user.get());
    }

    public void delete(String id) {
        userRepository.findById(userSession.userId())
                .flatMap(user -> wordRepository.findByIdAndAddedBy(id, user))
                .ifPresent(wordRepository::delete);

    }

    public List<Word> findGerman() {
        Optional<User> user = userRepository.findById(userSession.userId());

        if (user.isEmpty()) {
            return new ArrayList<>();
        }

        Language language = languageRepository.findByLanguageName(LanguageEnum.GERMAN);

        return wordRepository.findByLanguageAndAddedBy(language, user.get());
    }

    public List<Word> findItalian() {
        Optional<User> user = userRepository.findById(userSession.userId());

        if (user.isEmpty()) {
            return new ArrayList<>();
        }

        Language language = languageRepository.findByLanguageName(LanguageEnum.ITALIAN);
        return wordRepository.findByLanguageAndAddedBy(language, user.get());


    }
}