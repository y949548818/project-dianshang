package com.ds.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ds.dao.PostDao;
import com.ds.domain.Page;
import com.ds.domain.Post;
import com.mysql.jdbc.Statement;

public class PostDaoBean extends BaseDao<Post> implements PostDao {


	
	@Override
	public Post selectById(int postId) {
		String sql = "SELECT * FROM tb_post WHERE post_id = ?";
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
		final String sql="SELECT * FROM tb_post ORDER BY post_id ASC";
		
		
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Post>>(){

			@Override
			public List<Post> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				List<Post>posts=new ArrayList<Post>();
				while(rs.next()){
					Post post=new Post();
					post.setPostId(rs.getInt("post_id"));
					post.setTitle(rs.getString("title"));
					post.setUserId(rs.getInt("user_id"));
					post.setContent(rs.getString("content"));
					post.setPublishTime(rs.getTimestamp("publish_time"));
					post.setType(rs.getInt("type"));
					post.setReply_count(rs.getInt("reply_count"));
					post.setClick_count(rs.getInt("click_count"));
					posts.add(post);
				}
				return posts;
			}
		});
	}

	@Override
	public int insert(Post obj) {
		final String sql="insert into tb_post(title,user_id,content,publish_time,type,reply_count,click_count) values(?,?,?,?,?,?,?)";
		final Object[] params=new Object[]{
				obj.getTitle(),
				obj.getUserId(),
				obj.getContent(),
				obj.getPublishTime(),
				obj.getType(),
				obj.getReply_count(),
				obj.getClick_count()
				
			};
		//		return jdbcTemplate.update(sql, params);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int rc=jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
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
	 * 修改post的内容和标题，创建者id不允许修改,发布日期不允许修改
	 */
	@Override
	public int update(int id, Post obj) {
		String sql=""
				+ "update tb_post "
				+ "set "
				+ " title=?, "
				+ " user_id=?, "
				+ " content=?, "
				+ " publish_time=?, "
				+ " type=?, "
				+ " reply_count=?, "
				+ " click_count=? "
				+ " where "
				+ " post_id=? ";
		Object[] params=new Object[]{
				obj.getTitle(),
				obj.getUserId(),
				obj.getContent(),
				obj.getPublishTime(),
				obj.getType(),
				obj.getReply_count(),
				obj.getClick_count(),
				id
		};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int delete(int id) {
		String sql = "DELETE FROM tb_post WHERE post_id = ?";
		Object[] params=new Object[]{id};

		return jdbcTemplate.update(sql,params);
	}
	private static final String SQL_COUNT = "SELECT count(*) FROM tb_post";
	private static final String SQL_SELECT = "SELECT * FROM tb_post";
	
	@Override
	public Page<Post> page(int pageNo, int pageSize) {
		return super.pagedQuery(SQL_SELECT, SQL_COUNT, pageNo, pageSize,new Object[]{},  new BeanPropertyRowMapper<Post>(Post.class));
	}

}
