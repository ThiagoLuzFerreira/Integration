package com.thiago.integration.port.input;

import com.thiago.integration.domain.entity.Comment;

import java.util.List;

public interface ICommentUseCaseInput {

    List<Comment> fetchComments();

    List<Comment> filterComments(List<Comment> comments, Integer postId);
}
