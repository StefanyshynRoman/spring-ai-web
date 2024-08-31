package com.stefanyshyn.springaiweb.chat.dto;

import com.stefanyshyn.springaiweb.chat.enumerated.MessageType;

import java.time.LocalDateTime;

public record MessageDto(String content,
                         MessageType type,
                         LocalDateTime dateTime) {
}
