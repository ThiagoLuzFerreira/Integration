package com.thiago.integration.config;

import com.thiago.integration.domain.usecase.CommentUseCaseImpl;
import com.thiago.integration.port.input.ICommentUseCaseInput;
import com.thiago.integration.port.output.ICommentUseCaseOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ICommentUseCaseInput commentUseCase(ICommentUseCaseOutput commentUseCaseOutputAdapter){
        return new CommentUseCaseImpl(commentUseCaseOutputAdapter);
    }
}
