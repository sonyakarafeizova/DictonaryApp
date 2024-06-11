package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="languages")
public class Language extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String languageName;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private List<Word> words;

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
