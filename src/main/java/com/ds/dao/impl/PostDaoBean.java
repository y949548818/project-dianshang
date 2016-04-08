package com.ds.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ds.dao.PostDao;
import com.ds.domain.Post;
import com.ds.domain.User;
import com.mysql.jdbc.Statement;

public class PostDaoBean implements PostDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	
	@Override
	public Post selectById(int postId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_post WHERE postId = ?";
		Object[] params=new Object[]{postId};
		//return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(), params);
		List<Post> lists= jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<Post>(Post.class));
		if(lists.size()==0){
			return null;
		}
		else{
			return lists.get(0);
		}
	}

	@Override
	public List<Post> selectAll() {
		// TODO Auto-generated method stub
		final String sql="SELECT * FROM tb_post ORDER BY postId ASC";
		
		
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Post>>(){

			@Override
			public List<Post> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				// TODO Auto-generated method stub
				List<Post>posts=new ArrayList<Post>();
				while(rs.next()){
					Post post=new Post();
					post.setPostId(rs.getInt("postId"));
					post.setTitle(rs.getString("title"));
					post.setPostAdmin(rs.getInt("postAdmin"));
					post.setContent(rs.getString("content"));
					posts.add(post);
				}
				return posts;
			}
		});
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
				PreparedStatement st=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				for(int i=1;i<=params.length;i++){
					st.setObject(i, params[i-1]);
				}
				return st;
			}
		},keyHolder);
		if(rc>0){
			obj.setPostId(keyHolder.getKey().intValue());
		}
		return rc;
	}

	/**
	 * 修改post的内容和标题，创建者id不允许修改
	 */
	@Override
	public int update(int id, Post obj) {
		// TODO Auto-generated method stub
		String sql=""
				+ "update tb_post "
				+ "set "
				+ " content=?, "
				+ " title=? "
				+ "where "
				+ " postId=?";
		Object[] params=new Object[]{
				obj.getContent(),
				obj.getTitle(),
				id};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_post WHERE postId = ?";
		Object[] params=new Object[]{id};

		return jdbcTemplate.update(sql,params);
	}

}
