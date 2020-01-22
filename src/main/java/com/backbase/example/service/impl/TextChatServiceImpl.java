package com.backbase.example.service.impl;

import com.backbase.example.domain.TextChat;
import com.backbase.example.repository.TextChatRepository;
import com.backbase.example.service.TextChatService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TextChatServiceImpl implements TextChatService {

    private final TextChatRepository textChatRepository;
    private final String CHAT_DOESNT_EXIST = "chat doesnt exist";

    public TextChatServiceImpl(TextChatRepository textChatRepository) {
        this.textChatRepository = textChatRepository;
    }

    @Override
    public TextChat getChatById(Integer id) {
        return textChatRepository.getTextChatByChatId(id).orElseThrow(() -> new RuntimeException(CHAT_DOESNT_EXIST));
    }

    @Override
    public List<TextChat> getAllChats() {
        return textChatRepository.findAll();
    }

    @Override
    public void saveChat(String name) {
        TextChat textChat = new TextChat();
        textChat.setName(name);
        textChatRepository.save(textChat);
    }

    @Override
    public TextChat getChatByName(String name) {
        return textChatRepository.getTextChatByName(name).orElseThrow(() -> new RuntimeException(CHAT_DOESNT_EXIST));
    }
}
