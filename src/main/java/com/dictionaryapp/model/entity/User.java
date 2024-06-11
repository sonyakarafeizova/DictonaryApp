package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "addedBy", cascade = CascadeType.ALL)
    private List<Word> addedWords;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Word> getAddedWords() {
        return addedWords;
    }

    public void setAddedWords(List<Word> addedWords) {
        this.addedWords = addedWords;
    }
}
