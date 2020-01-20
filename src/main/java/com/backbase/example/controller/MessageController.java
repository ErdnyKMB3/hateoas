package com.backbase.example.controller;


import com.backbase.buildingblocks.presentation.errors.BadRequestException;
import com.backbase.buildingblocks.presentation.errors.InternalServerErrorException;
import com.backbase.example.domain.Message;
import com.backbase.example.service.MessageService;
import com.backbase.example.service.TextChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MessageController {

    private final TextChatService textChatService;
    private final MessageService messageService;

    @RequestMapping(value = "/greeting",
    method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String getGreeting( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        return "Hello, World";
    }

    @RequestMapping(value = "/message/add",
    method = {RequestMethod.POST})
    @ResponseStatus(HttpStatus.CREATED)
    public String addMessage(@RequestBody String text, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        Message message = new Message();
        message.setText(text);
        messageService.saveMessage(message);
        return "saved";
    }

    @RequestMapping(value = "/{textChatId}/messages",
    method = {RequestMethod.GET},
    produces = {"application/hal+json"})
    public Resource<Message> getMessagesForTextChat(@PathVariable final Integer textChatId) {
        List<Message> messages = messageService.
        return
    }


    @RequestMapping(value = "/message/get/{id}",
                method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public Message postMessage(@PathVariable Integer id, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        return messageService.getById(id);
    }

    @RequestMapping(value = "/all",
                method = {RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resource<Message> getAllMessages(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws BadRequestException, InternalServerErrorException {
        List<Message> allMessages = messageService.getAll();
        for (Message message: allMessages) {
            Integer messageId = message.getId();
            Link selfLink = linkTo(MessageController.class).slash(messageId).withSelfRel();
            message.add(selfLink);
        }
        if()
    }
}
