package com.qh.app.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dao.TypeDao;
import com.ds.domain.Page;
import com.ds.domain.Type;



@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class TypeDaoBeanTest {

	@Autowired
	TypeDao typeDao;
	
	/**
	 * 测试Insert
	 */
	@Test
	public void test1(){
		Type type=new Type();
		type.setName("测试2");
		
		int count=typeDao.insert(type);
		System.out.println(String.format("修改了%d条记录，Type的TypeId为%d",count,type.getTypeId()));
	}
	/**
	 * 测试update
	 */
	@Test
	public void test2(){
		Type type=typeDao.selectById(2);
		type.setName("测试3");
		typeDao.update(type.getTypeId(), type);
		System.out.println(type);
	}
	/**
	 * 测试delete
	 */
	@Test
	public void test3(){
		
	
		int count=typeDao.delete(2);
		if(count>0)
		System.out.println("删除成功");
	}
	/**
	 * 测试selectById
	 */
	@Test
	public void test4(){
		Type Type=typeDao.selectById(2);
	
		if(Type!=null)
		System.out.println(Type);
	}
	/**
	 * 测试selectAll
	 */
	@Test
	public void test5(){
		List<Type> Types=typeDao.selectAll();
	  
		if(Types!=null)
		System.out.println(Types);
	}
	/**
	 * 测试分页查询
	 */
	@Test
	public void test6(){
		Page<Type> page=typeDao.page(1, 10);
		System.out.println(page.getResult());
	}
}
