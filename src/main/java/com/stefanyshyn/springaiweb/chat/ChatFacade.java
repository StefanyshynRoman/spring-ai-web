package com.stefanyshyn.springaiweb.chat;

import com.stefanyshyn.springaiweb.chat.dto.MessageDto;
import com.stefanyshyn.springaiweb.chat.dto.MessageForm;

import java.util.List;

public interface ChatFacade {
    List<MessageDto> getMessages();

    void sendMessage(MessageForm form);
}
