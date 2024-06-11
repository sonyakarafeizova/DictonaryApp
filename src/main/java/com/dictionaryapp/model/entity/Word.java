package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="words")
public class Word extends BaseEntity{
    @Column(nullable = false, length = 40)
    private String term;

    @Column(nullable = false, length = 80)
    private String translation;

    @Column(length = 200)
    private String example;

    @Column(nullable = false)
    private LocalDate inputDate;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User addedBy;

}
