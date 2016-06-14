package com.ds.dao;

import java.util.List;

import com.ds.domain.Comment;

/**
 * Comment的Dao
 * @author hgg
 *
 */
public interface CommentDao  extends IDao<Comment>{

	List<Comment> selectAllByPostId(int postId);
	
}
