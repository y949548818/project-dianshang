package com.ds.service;

import com.ds.domain.User;

/**
 * 暂时先用做评论的服务接口
 * @author qq245521957
 *
 */
public interface CommentInfoService{
	String getCommentPublish();
	int getCommentId();
	User getCommentUser();
}
