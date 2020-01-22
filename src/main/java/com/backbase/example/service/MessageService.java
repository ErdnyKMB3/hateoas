package com.backbase.example.service;

import com.backbase.example.domain.Message;

import java.util.List;

public interface MessageService {

    Message getById(Integer id);

    void saveMessage(Message message);

    List<Message> getAll();

    List<Message> getMessagesForTextChat(Integer textChatId);

}
