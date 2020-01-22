package com.backbase.example.service;

import com.backbase.example.domain.TextChat;

import java.util.List;

public interface TextChatService {

    TextChat getChatById(Integer id);

    List<TextChat> getAllChats();

}
