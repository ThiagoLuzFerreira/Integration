package com.thiago.integration.domain.usecase;

import com.thiago.integration.domain.entity.Comment;
import com.thiago.integration.port.input.ICommentUseCaseInput;
import com.thiago.integration.port.output.ICommentUseCaseOutput;

import java.util.List;
import java.util.stream.Collectors;

public class CommentUseCaseImpl implements ICommentUseCaseInput {

    private final ICommentUseCaseOutput commentUseCaseOutputAdapter;

    public CommentUseCaseImpl(ICommentUseCaseOutput commentUseCaseOutputAdapter) {
        this.commentUseCaseOutputAdapter = commentUseCaseOutputAdapter;
    }


    @Override
    public List<Comment> fetchComments() {

        List<Comment> response = commentUseCaseOutputAdapter.fetchComments();

        return response;
    }

    public List<Comment> filterComments(List<Comment> comments, Integer postId){
        return comments.stream().filter(comment -> comment.getPostId().equals(postId)).collect(Collectors.toList());
    }
}
