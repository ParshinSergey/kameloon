package com.example.kameleoon.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate registered = LocalDate.now();

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    //@ElementCollection
    //@CollectionTable(name="quote_votes", joinColumns = @JoinColumn(name = "quote_id"))
    //@MapKeyColumn(name = "key")
    //@Column(name = "message")
    @OneToMany(cascade=ALL, mappedBy="quote")
    private Set<Vote> votes;

    private Integer rating = 0;


    public Quote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDate registered) {
        this.registered = registered;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public Map<String, Boolean> getVotes() {
        return votes;
    }

    public void setVotes(Map<String, Boolean> votes) {
        this.votes = votes;
    }*/

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "content='" + content + '\'' +
                ", registered=" + registered +
            /*    ", user=" + user +
                ", votes=" + votes +*/
                ", rating=" + rating +
                '}';
    }
}