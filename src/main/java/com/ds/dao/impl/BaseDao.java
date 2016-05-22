package com.ds.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ds.domain.Page;

public abstract class BaseDao<T> {

	@Autowired
	JdbcTemplate jdbcTemplate;
	/**
	 * 
	 * @param sqlSelect 用来选择所有的对象的sql语句
	 * @param sqlCount sql一共有多少数量的sql语句
	 * @param pageNo 第几页
	 * @param pageSize 页数
	 * @param params 参数
	 * @param rowMapper 
	 * @return
	 */
	protected Page<T> pagedQuery(String sqlSelect, String sqlCount, int pageNo, int pageSize, Object[] params, RowMapper<T> rowMapper) {
//		Assert.hasText(sqlSelect, "查询SQL不能为空");
//		Assert.hasText(sqlCount, "统计SQL不能为空");
//		Assert.isTrue(pageNo >= 1, "页码要求大于等于1");
//		Assert.isTrue(pageSize >= 1, "分页大小要求大于等于1");

		long totalCount = jdbcTemplate.queryForObject(sqlCount, params,Long.class);

		if (totalCount < 1) {
			return new Page<T>();
		}

		int startIndex = Page.getStartOfPage(pageNo, pageSize);

		String sql = sqlSelect + " LIMIT ?,? ";

		Object[] newParams = new Object[params.length + 2];
		for (int i = 0; i < params.length; i++) {
			newParams[i] = params[i];
		}
		newParams[newParams.length - 2] = startIndex;
		newParams[newParams.length - 1] = pageSize;

		List<T> list = jdbcTemplate.query(sql, newParams, rowMapper);
//		System.out.println("list is "+list);
//		System.out.println("params is "+newParams);
//		System.out.println("sql is"+sql);
		return new Page<T>(startIndex, totalCount, pageSize, list);
	}
}
