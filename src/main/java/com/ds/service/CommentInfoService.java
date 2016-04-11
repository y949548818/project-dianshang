package com.ds.service;

import com.ds.domain.User;

/**
 * 暂时先用做评论的服务接口
 * @author qq245521957
 *
 */
public interface CommentInfoService{
	/**
	 * 获取评论内容
	 * @return
	 */
	String getCommentContent(int commentId);
	/**
	 * 获取评论发布者
	 * @return
	 */
	int getCommentUserId(int commentId);
	
}
