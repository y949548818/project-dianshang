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
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ds.dao.UserDao;
import com.ds.domain.User;

public class UserDaoBean implements UserDao{

	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public User selectByUserName(String userName) {
		// TODO Auto-generated method stub
		String sql="select * from tb_user where username=?";
		final User user=new User();
		jdbcTemplate.query(sql, new Object[]{userName},new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				user.setUserId(rs.getInt("userId"));
				user.setUsername(rs.getString("username"));
				user.setLastIp(rs.getString("lastIp"));
			}
		});
		//		return user.getUserId() != null?user:null;
		return user.getUserId() != 0?user:null;

	}



	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		final String sql="insert into tb_user(username,credits,password,lastVisit,lastIp) values(?,?,?,?,?)";
		final Object[] params=new Object[]{
				user.getUsername(),
				user.getLastIp()};
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
			user.setUserId(keyHolder.getKey().intValue());
		}
		return rc;

	}

	@Override
	public int update(int userId, User user) {
		// TODO Auto-generated method stub
		String sql=""
				+ "update tb_user "
				+ "set "
				+ " userId=?, "
				+ " username=?, "
				+ " password=?, "
				+ " credits=?, "
				+ " lastIp=?, "
				+ "where "
				+ " userId=?";
		Object[] params=new Object[]{
				user.getUserId(),
				user.getUsername(),
				user.getLastIp()};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int delete(int userId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_user WHERE userId = ?";
		Object[] params=new Object[]{userId};

		return jdbcTemplate.update(sql,params);
	}

	@Override
	public User selectById(int userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_user WHERE userId = ?";
		Object[] params=new Object[]{userId};
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(), params);
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		final String sql="SELECT * FROM tb_user ORDER BY userId ASC";
		
		
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<User>>(){

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				// TODO Auto-generated method stub
				List<User>users=new ArrayList<User>();
				while(rs.next()){
					User user=new User();
					user.setUserId(rs.getInt("userId"));
					user.setUsername(rs.getString("username"));
					user.setLastIp(rs.getString("lastIp"));
					users.add(user);
				}
				return users;
			}
		});
	}

}
