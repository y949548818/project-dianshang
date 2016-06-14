package com.ds.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ds.dao.VideoDao;
import com.ds.domain.Page;
import com.ds.domain.Video;

@Repository
public class VideoDaoBean extends BaseDao<Video> implements VideoDao{

	@Override
	public Video selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Video obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(int id, Video obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<Video> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
