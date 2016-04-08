package com.ds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.dao.PostDao;
import com.ds.domain.Post;
import com.ds.service.PostInfoService;
import com.ds.service.PostPublishService;

/**
 * 
 * @author qq245521957
 *
 */
public class PostServiceBean implements PostInfoService,PostPublishService{

	
	@Autowired
	PostDao postDao;
	
	@Override
	public void publish(Post post) {
		// TODO Auto-generated method stub
		int count=postDao.insert(post);
		if(count>0){
			System.out.println("发布帖子成功");
		}
	}

	@Override
	public String getPostTitle(int id) {
		// TODO Auto-generated method stub
		Post post=postDao.selectById(id);
		return post.getTitle();
	}

	
}
