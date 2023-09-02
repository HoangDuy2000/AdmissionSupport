/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository;

import com.vhd.pojo.Comment;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CommentRepository {
    List<Comment> getComments(int newsId);
    Comment addComment(Comment c);
}
