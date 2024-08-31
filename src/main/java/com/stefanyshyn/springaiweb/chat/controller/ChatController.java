package com.stefanyshyn.springaiweb.chat.controller;

import com.stefanyshyn.springaiweb.chat.ChatFacade;
import com.stefanyshyn.springaiweb.chat.dto.MessageForm;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/ai/chat")
@RequiredArgsConstructor
class ChatController {
    private final ChatFacade chatFacade;

    @GetMapping("/messages")
    String getMessages(Model model) {
        model.addAttribute("messages", chatFacade.getMessages());
        model.addAttribute(new MessageForm(StringUtils.EMPTY));
        return "chat/chat-page";
    }
    @PostMapping("/messages")
    String sendMessage(Model model, @ModelAttribute("messageForm") MessageForm messageForm){
        chatFacade.sendMessage(messageForm);
        model.addAttribute("messages", chatFacade.getMessages());
        return "chat/chat-page";

    }
}
