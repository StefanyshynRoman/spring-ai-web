package com.stefanyshyn.springaiweb.chat.domain;

import com.stefanyshyn.springaiweb.chat.ChatFacade;
import com.stefanyshyn.springaiweb.chat.dto.MessageDto;
import com.stefanyshyn.springaiweb.chat.dto.MessageForm;
import com.stefanyshyn.springaiweb.chat.enumerated.MessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
class ChatService implements ChatFacade {
    private final List<MessageDto> messages = new ArrayList<>();
    private final ChatModel chatModel;

    @Override
    public List<MessageDto> getMessages() {
        return messages;
    }

    @Override
    public void sendMessage(MessageForm form) {
        Message userMessage = new UserMessage(form.content());
        Message systemMessage = getSystemMessage();
        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        messages.add(new MessageDto(form.content(), MessageType.USER, LocalDateTime.now()));
        String result = chatModel.call(prompt)
                .getResult()
                .getOutput()
                .getContent();
        messages.add(new MessageDto(result, MessageType.SYSTEM, LocalDateTime.now()));

    }

    private Message getSystemMessage() {
        String systemPrompt = """
                Jestes asystentem, ktory odpowiada na pytania klientow dotyczasych firmy MM factory.
                Dolanczam do kontekstu  wiadomosci, ktore wczesniej wymieniles z uzytkownikiem :{message}.
                """;
        return new SystemPromptTemplate(systemPrompt)
                .createMessage(Map.of(
                        "messages", messages
                ));
    }
}
