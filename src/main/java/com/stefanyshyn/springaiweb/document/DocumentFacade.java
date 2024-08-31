package com.stefanyshyn.springaiweb.document;

import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentFacade {
    List<Document> getSimilarDocuments(String userPrompt);

    void addDocuments(List<Document> documents);
}
