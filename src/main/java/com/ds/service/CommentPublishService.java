package com.ds.service;

import com.ds.domain.Comment;

public interface CommentPublishService {

	/**
	 * 发布一个帖子
	 * @param comment
	 * @return 是否发布成功
	 */
	boolean Publish(Comment comment);
}
