package com.ds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.dao.PostDao;
import com.ds.domain.Page;
import com.ds.domain.Post;
import com.ds.service.PostInfoService;
import com.ds.service.PostPublishService;
import com.ds.service.PostSelectService;

/**
 * 
 * @author qq245521957
 *
 */
public class PostServiceBean implements PostInfoService,PostPublishService,PostSelectService{

	
	@Autowired
	PostDao postDao;
	
	@Override
	public boolean publish(Post post) {
		int count=postDao.insert(post);
		if(count>0){
//			System.out.println("发布帖子成功");
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public String getPostTitle(int id) {
		Post post=postDao.selectById(id);
		return post.getTitle();
	}

	@Override
	public Page<Post> getPosts(int pageNo, int pageSize) {
		return postDao.page(pageNo, pageSize);
	}

	@Override
	public Post selectPostById(int id) {
		// TODO Auto-generated method stub
		return postDao.selectById(id);
	}

	
}
