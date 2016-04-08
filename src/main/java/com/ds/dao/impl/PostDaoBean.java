package com.ds.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ds.dao.PostDao;
import com.ds.domain.Post;

public class PostDaoBean implements PostDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public Post selectById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Post obj) {
		// TODO Auto-generated method stub
		final String sql="insert into tb_post(title,postAdmin,content) values(?,?,?)";
		final Object[] params=new Object[]{
				obj.getTitle(),
				obj.getPostAdmin(),
				obj.getContent()
				};
		//		return jdbcTemplate.update(sql, params);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int rc=jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement st=con.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
				return st;
			}
		},keyHolder);
		if(rc>0){
			obj.setPostId(keyHolder.getKey().intValue());
		}
		return rc;
	}

	@Override
	public int update(int id, Post obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}