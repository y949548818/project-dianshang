package com.ds.service;

import com.ds.domain.Post;

public interface PostPublishService {

	/**
	 * 发布一条评论
	 * @param post
	 * @return TODO
	 */
	boolean publish(Post post);
}
