package com.clayn.springtest.model;

import com.clayn.springtest.validation.UniqueMovieTitle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    @Column(nullable = false)
    @NotBlank
    @UniqueMovieTitle
    private String title;
    @NotBlank
    private String description;
    @Positive
    private int duration;

    @ManyToOne(targetEntity = Director.class, optional = false, cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Director director;
}
