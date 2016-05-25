package com.ds.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ds.dao.UserDao;
import com.ds.domain.Page;
import com.ds.domain.User;

public class UserDaoBean extends BaseDao<User> implements UserDao{



	@Override
	public User selectByUserName(String userName) {
		String sql="select * from tb_user where username=?";
		final User user=new User();
		jdbcTemplate.query(sql, new Object[]{userName},new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setLastIp(rs.getString("last_ip"));
				user.setPassword(rs.getString("password"));
				user.setHeaderPath(rs.getString("header_path"));
				user.setLastTime(rs.getTimestamp("last_time"));
			}
		});
		//		return user.getUserId() != null?user:null;
		return user.getUserId() != 0?user:null;

	}



	@Override
	public int insert(User user) {
		final String sql="insert into tb_user(username,password,last_time,last_ip,header_path) values(?,?,?,?,?)";
		final Object[] params=new Object[]{
				user.getUsername(),
				user.getPassword(),
				user.getLastTime(),
				user.getLastIp(),
				user.getHeaderPath()
				
		};
		//		return jdbcTemplate.update(sql, params);
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int rc=jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement st=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

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
		String sql=""
				+ "update tb_user "
				+ "set "
				+ " user_id=?, "
				+ " username=?, "
				+ " password=?, "
				+ " header_path=?, "
				+ " last_time=?, "
				+ " last_ip=? "
				+ "where "
				+ " user_id=? ";
		Object[] params=new Object[]{
				user.getUserId(),
				user.getUsername(),
				user.getPassword(),
				user.getHeaderPath(),
				user.getLastTime(),
				user.getLastIp(),
				userId
			};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int delete(int userId) {
		String sql = "DELETE FROM tb_user WHERE user_id = ?";
		Object[] params=new Object[]{userId};

		return jdbcTemplate.update(sql,params);
	}

	@Override
	public User selectById(int userId) {
		String sql = "SELECT * FROM tb_user WHERE user_id = ?";
		Object[] params=new Object[]{userId};
		//return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(), params);
		List<User> lists= jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<User>(User.class));
		if(lists.size()==0){
			return null;
		}
		else{
			return lists.get(0);
		}
	}
	
	
	@Override
	public List<User> selectAll() {

		final String sql="SELECT * FROM tb_user ORDER BY user_id ASC";
		
		
		return jdbcTemplate.query(sql,new ResultSetExtractor<List<User>>(){

			@Override
			public List<User> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				List<User>users=new ArrayList<User>();
				while(rs.next()){
					User user=new User();
					user.setUserId(rs.getInt("user_id"));
					user.setUsername(rs.getString("username"));
					user.setLastIp(rs.getString("last_ip"));
					user.setPassword(rs.getString("password"));
					user.setHeaderPath(rs.getString("header_path"));
					user.setLastTime(rs.getTimestamp("last_time"));
					users.add(user);
				}
				return users;
			}
		});
	}

	private static final String SQL_COUNT = "SELECT count(*) FROM tb_user";
	private static final String SQL_SELECT = "SELECT * FROM tb_user";

	@Override
	public Page<User> page(int pageNo, int pageSize) {
		return super.pagedQuery(SQL_SELECT, SQL_COUNT, pageNo, pageSize,new Object[]{},  new BeanPropertyRowMapper<User>(User.class));
	}

}
