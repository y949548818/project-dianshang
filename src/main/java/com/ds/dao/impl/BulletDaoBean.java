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
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ds.dao.BulletDao;
import com.ds.domain.Bullet;
import com.ds.domain.Page;
import com.ds.domain.Post;
import com.mysql.jdbc.Statement;

@Repository
public class BulletDaoBean extends BaseDao<Bullet> implements BulletDao{

	@Override
	public Bullet selectById(int id) {
		String sql="select * from tb_bullet where bullet_id=?";
		Object[] params=new Object[]{id};
		final Bullet bullet=new Bullet();
		jdbcTemplate.query(sql, params, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				bullet.setBulletId(rs.getInt("bullet_id"));
				bullet.setColor(rs.getInt("color"));
				bullet.setContent(rs.getString("content"));
				bullet.setMode(rs.getInt("mode"));
				bullet.setPublishTime(rs.getTimestamp("publish_time"));
				bullet.setUserId(rs.getInt("user_id"));
				bullet.setVideoId(rs.getInt("video_id"));
				bullet.setVideoTime(rs.getInt("video_time"));
				
			}
			
		});
		return (bullet.getBulletId()==0)?null:bullet;
	}

	@Override
	public List<Bullet> selectAll() {
		String sql="select * from tb_bullet";
		List<Bullet> list=new ArrayList<Bullet>();
		return jdbcTemplate.query(sql, new RowMapper<Bullet>(){

			@Override
			public Bullet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Bullet bullet=new Bullet();
				bullet.setBulletId(rs.getInt("bullet_id"));
				bullet.setColor(rs.getInt("color"));
				bullet.setContent(rs.getString("content"));
				bullet.setMode(rs.getInt("mode"));
				bullet.setPublishTime(rs.getTimestamp("publish_time"));
				bullet.setUserId(rs.getInt("user_id"));
				bullet.setVideoId(rs.getInt("video_id"));
				bullet.setVideoTime(rs.getInt("video_time"));
				return bullet;
			}
			
		});
	}

	@Override
	public int insert(Bullet bullet) {
		final String sql="insert into tb_bullet(user_id,video_id,content,publish_time,video_time,color,mode) values(?,?,?,?,?,?,?)";
		final Object[] params=new Object[]{
				bullet.getUserId(),
				bullet.getVideoId(),
				bullet.getContent(),
				bullet.getPublishTime(),
				bullet.getVideoTime(),
				bullet.getColor(),
				bullet.getMode()
		};
		KeyHolder keyHolder=new GeneratedKeyHolder();
		int rc=jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement st=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				for(int i=0;i<params.length;i++){
					st.setObject(i+1, params[i]);
				}
				return st;
			}
			
		}, keyHolder);
		if(rc>0){
			bullet.setBulletId(keyHolder.getKey().intValue());
		}
		return rc;
	}

	@Override
	public int update(int id, Bullet obj) {
		String sql="update tb_bullet set user_id=?,video_id=?,content=?,publish_time=?,video_time=?,color=?,mode=? where bullet_id=?";
		Object[] params=new Object[]{
				obj.getUserId(),
				obj.getVideoId(),
				obj.getContent(),
				obj.getPublishTime(),
				obj.getVideoTime(),
				obj.getColor(),
				obj.getMode(),
				id
		};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int delete(int id) {
		String sql="delete from tb_bullet where bullet_id=?";
		Object[] params=new Object[]{id};
		return jdbcTemplate.update(sql, params);
	}

	
	private static final String SQL_COUNT = "SELECT count(*) FROM tb_bullet";
	private static final String SQL_SELECT = "SELECT * FROM tb_bullet";
	
	@Override
	public Page<Bullet> page(int pageNo, int pageSize) {
		return super.pagedQuery(SQL_SELECT, SQL_COUNT, pageNo, pageSize,new Object[]{},  new BeanPropertyRowMapper<Bullet>(Bullet.class));
	}

	@Override
	public List<Bullet> selectAllByVideoId(int videoId) {
		String sql="SELECT * FROM tb_bullet where video_id = ? order by video_time";
		
		return jdbcTemplate.query(sql,new Object[]{videoId}, new ResultSetExtractor<List<Bullet>>(){

			@Override
			public List<Bullet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bullet>bullets=new ArrayList<Bullet>();
				while(rs.next()){
					Bullet bullet=new Bullet();
					bullet.setBulletId(rs.getInt("bullet_id"));
					bullet.setColor(rs.getInt("color"));
					bullet.setContent(rs.getString("content"));
					bullet.setPublishTime(rs.getTimestamp("publish_time"));
					bullet.setVideoId(rs.getInt("video_id"));
					bullet.setVideoTime(rs.getInt("video_time"));
					bullet.setMode(rs.getInt("mode"));
					bullet.setUserId(rs.getInt("user_id"));
					bullets.add(bullet);
				}
				return bullets;
			}
			
		});
	}

	@Override
	public List<Bullet> selectAllByVideoIdAndStartTime(int videoId, int startTime) {
		String sql="SELECT * FROM tb_bullet where video_id = ? and video_time >= ? order by video_time";
		
		return jdbcTemplate.query(sql,new Object[]{videoId,startTime}, new ResultSetExtractor<List<Bullet>>(){

			@Override
			public List<Bullet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bullet>bullets=new ArrayList<Bullet>();
				while(rs.next()){
					Bullet bullet=new Bullet();
					bullet.setBulletId(rs.getInt("bullet_id"));
					bullet.setColor(rs.getInt("color"));
					bullet.setContent(rs.getString("content"));
					bullet.setPublishTime(rs.getTimestamp("publish_time"));
					bullet.setVideoId(rs.getInt("video_id"));
					bullet.setVideoTime(rs.getInt("video_time"));
					bullet.setMode(rs.getInt("mode"));
					bullet.setUserId(rs.getInt("user_id"));
					bullets.add(bullet);
				}
				return bullets;
			}
			
		});
	}

	@Override
	public List<Bullet> selectSomeByVideoIdAndStartTime(int videoId, int startTime, int amount) {
String sql="SELECT * FROM tb_bullet where video_id = ? and video_time >= ? order by video_time limit 0,?";
		
		return jdbcTemplate.query(sql,new Object[]{videoId,startTime,amount}, new ResultSetExtractor<List<Bullet>>(){

			@Override
			public List<Bullet> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bullet>bullets=new ArrayList<Bullet>();
				while(rs.next()){
					Bullet bullet=new Bullet();
					bullet.setBulletId(rs.getInt("bullet_id"));
					bullet.setColor(rs.getInt("color"));
					bullet.setContent(rs.getString("content"));
					bullet.setPublishTime(rs.getTimestamp("publish_time"));
					bullet.setVideoId(rs.getInt("video_id"));
					bullet.setVideoTime(rs.getInt("video_time"));
					bullet.setMode(rs.getInt("mode"));
					bullet.setUserId(rs.getInt("user_id"));
					bullets.add(bullet);
				}
				return bullets;
			}
			
		});
	}


	
}
