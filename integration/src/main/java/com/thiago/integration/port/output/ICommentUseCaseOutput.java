package com.thiago.integration.port.output;

import com.thiago.integration.domain.entity.Comment;

import java.util.List;

public interface ICommentUseCaseOutput {

    List<Comment> fetchComments();

    List<Comment> filterComments(List<Comment> comments, Integer postId);
}
