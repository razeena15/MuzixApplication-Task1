package com.stackroute.MuzixApplication.domain;

import lombok.*;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
@Data

public class Track {
    @Id
    int id;
    String name;
    String comment;
}
