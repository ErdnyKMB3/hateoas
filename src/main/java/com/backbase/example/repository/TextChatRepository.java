package com.backbase.example.repository;

import com.backbase.example.domain.TextChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextChatRepository extends JpaRepository<TextChat, Integer> {
}
