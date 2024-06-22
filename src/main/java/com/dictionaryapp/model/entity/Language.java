package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="languages")
public class Language extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LanguageEnum languageName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private Set<Word> words;

    public Language() {
        this.words = new HashSet<>();

    }

    public Language(LanguageEnum name, String description) {
        super();

        this.languageName = name;
        this.description = description;
    }
    public LanguageEnum getLanguageName() {
        return languageName;
    }

    public void setLanguageName(LanguageEnum languageName) {
        this.languageName = languageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }

}
