package com.ds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.dao.CommentDao;
import com.ds.domain.Comment;
import com.ds.service.CommentInfoService;
import com.ds.service.CommentPublishService;

/**
 * 
 * @author y949548818
 *
 */
public class CommentServiceBean  implements CommentInfoService,CommentPublishService{


	@Autowired
	CommentDao commentDao;

	@Override
	public boolean Publish(Comment comment) {
		int count=commentDao.insert(comment);
		if(count>0){
			return true;
		}
		else{
			return false;			
		}
	}

	@Override
	public String getCommentContent(int commentId) {
		Comment comment=commentDao.selectById(commentId);
		return comment.getContent();
	}

	@Override
	public int getCommentUserId(int commentId) {
		Comment comment=commentDao.selectById(commentId);
		return comment.getUserId();
	}
	

}
