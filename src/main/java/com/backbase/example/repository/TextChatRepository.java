package com.backbase.example.repository;

import com.backbase.example.domain.TextChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;


@RepositoryDefinition(domainClass = TextChat.class, idClass = Integer.class)
public interface TextChatRepository extends JpaRepository<TextChat, Integer> {

    TextChat getTextChatByChatId(@Param("id")Integer id);
}
