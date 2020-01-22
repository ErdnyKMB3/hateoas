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
    private final String MESSAGE_DOESNT_EXIST = "message doesnt exist";

    public MessageServiceImpl(MessageRepository messageRepository, TextChatService textChatService) {
        this.messageRepository = messageRepository;
        this.textChatService = textChatService;
    }

    @Override
    public Message getById(Integer id) {
        return messageRepository.findByMessageId(id).orElseThrow(() -> new RuntimeException(MESSAGE_DOESNT_EXIST));
    }

    @Override
    public void saveMessage(String text, String chatName) {
        TextChat chat = textChatService.getChatByName(chatName);
        Message message = new Message();
        message.setChat(chat);
        message.setText(text);
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
