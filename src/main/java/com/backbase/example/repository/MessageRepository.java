package com.backbase.example.repository;

import com.backbase.example.domain.Message;
import com.backbase.example.domain.TextChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;
import java.util.Optional;


@RepositoryDefinition(domainClass = Message.class, idClass = Integer.class)
public interface MessageRepository extends JpaRepository<Message, Integer> {

    Optional<Message> findByMessageId(Integer id);

    List<Message> findAllByChat(TextChat id);
}
