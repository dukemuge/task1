package com.pezesha.task.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Recipient {
    @Id
    @GeneratedValue
    private Long id;
}
