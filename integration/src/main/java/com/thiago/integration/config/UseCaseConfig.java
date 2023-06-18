package com.thiago.integration.config;

import com.thiago.integration.domain.usecase.CommentUseCaseImpl;
import com.thiago.integration.domain.usecase.RbrfCpfUseCaseImpl;
import com.thiago.integration.port.input.ICommentUseCaseInput;
import com.thiago.integration.port.input.IRbrfCpfUseCaseInput;
import com.thiago.integration.port.output.ICommentUseCaseOutput;
import com.thiago.integration.port.output.IRbrfCpfUseCaseOutput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ICommentUseCaseInput commentUseCase(ICommentUseCaseOutput commentUseCaseOutputAdapter){
        return new CommentUseCaseImpl(commentUseCaseOutputAdapter);
    }

    @Bean
    IRbrfCpfUseCaseInput rbrfCpfUseCase(IRbrfCpfUseCaseOutput rbrfCpfUseCaseOutputAdapter){
        return new RbrfCpfUseCaseImpl(rbrfCpfUseCaseOutputAdapter);
    }
}
