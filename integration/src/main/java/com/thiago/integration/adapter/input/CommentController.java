package com.thiago.integration.adapter.input;

import com.thiago.integration.domain.entity.Comment;
import com.thiago.integration.adapter.dto.CommentDTO;
import com.thiago.integration.port.input.ICommentUseCaseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private ICommentUseCaseInput commentUseCase;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> getComments(@RequestParam(required = false) Integer postId){
        List<Comment> comments = commentUseCase.fetchComments();

        if(postId != null){
            comments = commentUseCase.filterComments(comments, postId);
        }

        List<CommentDTO> commentDTOList = comments.stream().map(c -> new CommentDTO(c.getName(), c.getBody())).collect(Collectors.toList());

        if(comments != null){
            return ResponseEntity.ok(commentDTOList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
