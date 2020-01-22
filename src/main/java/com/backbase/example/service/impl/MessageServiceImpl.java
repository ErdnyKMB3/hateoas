package com.backbase.example.service.impl;

import com.backbase.example.domain.Message;
import com.backbase.example.domain.TextChat;
import com.backbase.example.repository.MessageRepository;
import com.backbase.example.service.MessageService;
import com.backbase.example.service.TextChatService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final TextChatService textChatService;

    public MessageServiceImpl(MessageRepository messageRepository, TextChatService textChatService) {
        this.messageRepository = messageRepository;
        this.textChatService = textChatService;
    }

    @Override
    public Message getById(Integer id) {
        return messageRepository.findByMessageId(id);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getMessagesForTextChat(Integer textChatId) {
        TextChat textChat = textChatService.getChatById(textChatId);
        return messageRepository.findAllByChat(textChat);
    }
}
