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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.ds.dao.TypeDao;
import com.ds.domain.Page;
import com.ds.domain.Type;
import com.ds.domain.User;


public class TypeDaoBean extends BaseDao implements TypeDao{

	@Override
	public Type selectById(int typeId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM tb_type WHERE type_id = ?";
		Object[] params=new Object[]{typeId};
		//return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(), params);
		List<Type> lists= jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<Type>(Type.class));
		if(lists.size()==0){
			return null;
		}
		else{
			return lists.get(0);
		}
	}

	@Override
	public List<Type> selectAll() {
		// TODO Auto-generated method stub
		final String sql="SELECT * FROM tb_type ORDER BY type_id ASC";


		return jdbcTemplate.query(sql,new ResultSetExtractor<List<Type>>(){

			@Override
			public List<Type> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
				// TODO Auto-generated method stub
				List<Type>types=new ArrayList<Type>();
				while(rs.next()){
					Type type=new Type();
					type.setTypeId(rs.getInt("type_id"));
					type.setName(rs.getString("name"));
					types.add(type);
				}
				return types;
			}
		});
	}

	@Override
	public int insert(Type obj) {
		// TODO Auto-generated method stub
		final String sql="insert into tb_type(name) values(?)";
		final Object[] params=new Object[]{
				obj.getName()

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
			obj.setTypeId(keyHolder.getKey().intValue());
		}
		return rc;
	}

	@Override
	public int update(int id, Type obj) {
		// TODO Auto-generated method stub
		String sql=""
				+ "update tb_type "
				+ "set "
				+ " type_id=?, "
				+ " name=? "
				+ " where "
				+ " type_id=? ";
		Object[] params=new Object[]{
				obj.getTypeId(),
				obj.getName(),
				id
		};
		return jdbcTemplate.update(sql,params);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tb_type WHERE type_id = ?";
		Object[] params=new Object[]{id};

		return jdbcTemplate.update(sql,params);
	}

	private static final String SQL_COUNT = "SELECT count(*) FROM tb_type";
	private static final String SQL_SELECT = "SELECT * FROM tb_type";
	@Override
	public Page<Type> page(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return super.pagedQuery(SQL_SELECT, SQL_COUNT, pageNo, pageSize,new Object[]{},  new BeanPropertyRowMapper<Type>(Type.class));
	}

}
