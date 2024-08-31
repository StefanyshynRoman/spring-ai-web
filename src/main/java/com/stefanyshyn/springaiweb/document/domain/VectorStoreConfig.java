package com.stefanyshyn.springaiweb.document.domain;

import org.springframework.ai.vectorstore.PgVectorStore;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class VectorStoreConfig {
    @Bean
    VectorStore pgVectorStore(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingClient){
        return new PgVectorStore(jdbcTemplate, embeddingClient);
    }
}
