package com.backbase.example.service.impl;

import com.backbase.example.domain.Message;
import com.backbase.example.repository.MessageRepository;
import com.backbase.example.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message getById(Integer id) {
        return messageRepository.getById(id);
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
        return messageRepository.
    }
}
