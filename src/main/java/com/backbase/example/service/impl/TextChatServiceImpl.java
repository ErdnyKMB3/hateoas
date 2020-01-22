package com.backbase.example.service.impl;

import com.backbase.example.domain.TextChat;
import com.backbase.example.repository.TextChatRepository;
import com.backbase.example.service.TextChatService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TextChatServiceImpl implements TextChatService {

    private final TextChatRepository textChatRepository;

    public TextChatServiceImpl(TextChatRepository textChatRepository) {
        this.textChatRepository = textChatRepository;
    }

    @Override
    public TextChat getChatById(Integer id) {
        return textChatRepository.getTextChatByChatId(id);
    }

    @Override
    public List<TextChat> getAllChats() {
        return textChatRepository.findAll();
    }
}
