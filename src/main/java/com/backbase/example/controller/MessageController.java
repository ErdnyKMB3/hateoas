package com.backbase.example.controller;


import com.backbase.example.domain.Message;
import com.backbase.example.service.MessageService;
import com.backbase.example.service.TextChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final TextChatService textChatService;

    @RequestMapping(value = "/greeting",
    method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String getGreeting() {
        return "Hello, World";
    }

    @RequestMapping(value = "/message/add",
    method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.CREATED)
    public void addMessage(@RequestBody String text, @RequestParam("chatName") String chatName)  {
        messageService.saveMessage(text, chatName);
    }

    @RequestMapping(value = "/textchat/add",
    method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.CREATED)
    public void addTextChat(@RequestParam("chatName") String chatName) {
        textChatService.saveChat(chatName);
    }

    @RequestMapping(value = "/{textChatId}/messages",
    method = {RequestMethod.GET},
    produces = {"application/hal+json"})
    @ResponseBody
    public Resources<Message> getMessagesForTextChat(@PathVariable final Integer textChatId) {
        List<Message> messages = messageService.getMessagesForTextChat(textChatId);
        for(final Message message: messages) {
            Link selfLink = linkTo(methodOn(MessageController.class).getMessageById(message.getMessageId())).withSelfRel();
            message.add(selfLink);
        }
        Link link = linkTo(methodOn(MessageController.class).getMessagesForTextChat(textChatId)).withSelfRel();
        return new Resources<>(messages, link);
    }


    @RequestMapping(value = "/message/get/{id}",
                method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public Message getMessageById(@PathVariable Integer id) throws BadRequestException, InternalServerErrorException {
        return messageService.getById(id);
    }

    @RequestMapping(value = "/all",
                method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resources<Message> getAllMessages() throws BadRequestException, InternalServerErrorException {
        List<Message> allMessages = messageService.getAll();
        for (Message message: allMessages) {
            Integer messageId = message.getMessageId();
            Link selfLink = linkTo(MessageController.class).slash(messageId).withSelfRel();
            message.add(selfLink);
        }
        Link link = linkTo(MessageController.class).withSelfRel();
        return new Resources<>(allMessages, link);
    }
}
