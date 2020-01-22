package com.backbase.example.repository;

import com.backbase.example.domain.TextChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.Optional;


@RepositoryDefinition(domainClass = TextChat.class, idClass = Integer.class)
public interface TextChatRepository extends JpaRepository<TextChat, Integer> {

    Optional<TextChat> getTextChatByChatId(Integer id);

    Optional<TextChat> getTextChatByName(String chatName);
}
