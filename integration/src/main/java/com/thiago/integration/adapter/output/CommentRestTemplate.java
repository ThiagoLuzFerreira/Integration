package com.thiago.integration.adapter.output;

import com.thiago.integration.domain.entity.Comment;
import com.thiago.integration.port.output.ICommentUseCaseOutput;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentRestTemplate implements ICommentUseCaseOutput {

    private final RestTemplate restTemplate;

    private final String url = "https://jsonplaceholder.typicode.com/comments";

    public CommentRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Comment> fetchComments() {

        ResponseEntity<Comment[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Comment[].class);
        Comment[] comments = response.getBody();

        if(comments != null){
            return Arrays.asList(comments);
        }
         return null;
    }

    public List<Comment> filterComments(List<Comment> comments, Integer postId){
        return comments.stream().filter(comment -> comment.getPostId().equals(postId)).collect(Collectors.toList());
    }
}
