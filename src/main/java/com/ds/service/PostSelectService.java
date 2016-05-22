package com.ds.service;

import com.ds.domain.Page;
import com.ds.domain.Post;
import com.ds.domain.User;

/**
 * 用来选择帖子的服务接口
 * @author qq245521957
 *
 */
public interface PostSelectService {

	/**
	 * 分页查询Post
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<Post> getPosts(int pageNo, int pageSize);
}
