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

import com.ds.dao.CommentDao;
import com.ds.domain.Comment;
import com.ds.domain.User;

public class CommentDaoBean implements CommentDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Comment selectById(int commentId) {
		String sql = "SELECT * FROM tb_comment WHERE commentId = ?";
		Object[] params=new Object[]{commentId};
		List<Comment> lists= jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<Comment>(Comment.class));
		if(lists.size()==0){
			return null;
		}
		else{
			return lists.get(0);
		}
	}

	@Override
	public List<Comment> selectAll() {
		String sql="SELECT * FROM tb_comment";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Comment>>(){

			@Override
			public List<Comment> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Comment>comments=new ArrayList<Comment>();
				while(rs.next()){
					Comment comment=new Comment();
					comment.setCommentId(rs.getInt("commentId"));
					comment.setContent(rs.getString("content"));
					comment.setDate(rs.getDate("date"));
					comment.setPostId(rs.getInt("postId"));
					comment.setUserId(rs.getInt("userId"));
					comments.add(comment);
				}
				return comments;
			}
			
		});
	}

	@Override
	public int insert(Comment comment) {
		String sql="insert into tb_comment(content,date,postId,userId) values(?,?,?,?)";
		Object[] params=new Object[]{
				comment.getContent(),
				comment.getDate(),
				comment.getPostId(),
				comment.getUserId()
		};
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int rc=jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st=con.prepareStatement(sql);
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
				return st;
			}
			
		}, keyHolder);
		if(rc>0){
			comment.setCommentId(keyHolder.getKey().intValue());
		}
		return rc;
	}

	@Override
	public int update(int id, Comment comment) {
		String sql=""
				+ "update tb_comment "
				+ "set "
				+ " commentId=?, "
				+ " content=?, "
				+ " date=?, "
				+ " postId=?, "
				+ " userId=?";
	//	Object[] params=new Object[]{
/*				comment.getUserId(),
				comment.get,
				comment.getLastIp()};*/
//		return jdbcTemplate.update(sql,params);
	return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
