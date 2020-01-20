package com.backbase.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "chat")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class TextChat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer chatId;

    private Integer count;
}
