package com.backbase.example.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "message")
@RequiredArgsConstructor
public class Message extends ResourceSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    @OneToMany
    private List<Integer> textChatId;
}
