package com.pythip.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;

import com.pythip.common.annotation.Mybatis;
/**
 * 基础数据库操作类，利用@mybatis注解，减少使用时对命名空间的重复输入
 * @author chemphone
 * **/
public class BaseService implements InitializingBean {
	private String namespace;

	@Resource
	protected SqlSessionTemplate sessionTemplate;

	public <T> T selectOne(String statement) {
		return this.sessionTemplate.selectOne(this.namespace + statement);
	}

	public <T> T selectOne(String statement, Object parameter) {
		return this.sessionTemplate.selectOne(this.namespace + statement,
				parameter);
	}

	public <E> List<E> selectList(String statement) {
		return this.sessionTemplate.selectList(this.namespace + statement);
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		return this.sessionTemplate.selectList(this.namespace + statement,
				parameter);
	}

	public <E> List<E> selectList(String statement, Object parameter,
			RowBounds rowBounds) {
		return this.sessionTemplate.selectList(this.namespace + statement,
				parameter, rowBounds);
	}

	public <K, V> Map<K, V> selectMap(String statement, String mapKey) {
		return this.sessionTemplate.selectMap(this.namespace + statement,
				mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey) {
		return this.sessionTemplate.selectMap(this.namespace + statement,
				parameter, mapKey);
	}

	public <K, V> Map<K, V> selectMap(String statement, Object parameter,
			String mapKey, RowBounds rowBounds) {
		return this.sessionTemplate.selectMap(this.namespace + statement,
				parameter, mapKey, rowBounds);
	}

	public void select(String statement, Object parameter, ResultHandler handler) {
		this.sessionTemplate.select(this.namespace + statement, parameter,
				handler);
	}

	public void select(String statement, ResultHandler handler) {
		this.sessionTemplate.select(this.namespace + statement, handler);
	}

	public void select(String statement, Object parameter, RowBounds rowBounds,
			ResultHandler handler) {
		this.sessionTemplate.select(this.namespace + statement, rowBounds,
				handler);
	}

	public int insert(String statement) {
		return this.sessionTemplate.insert(this.namespace + statement);
	}

	public int insert(String statement, Object parameter) {
		return this.sessionTemplate.insert(this.namespace + statement,
				parameter);
	}

	public int update(String statement) {
		return this.sessionTemplate.update(this.namespace + statement);
	}

	public int update(String statement, Object parameter) {
		return this.sessionTemplate.update(this.namespace + statement,
				parameter);
	}

	public int delete(String statement) {
		return this.sessionTemplate.update(this.namespace + statement);
	}

	public int delete(String statement, Object parameter) {
		return this.sessionTemplate.delete(this.namespace + statement,
				parameter);
	}

	public void setNamespace(String namespace) {
		this.namespace = (namespace + ".");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.namespace == null) {
			String name = getClass().getSimpleName();
			boolean ret = getClass().isAnnotationPresent(Mybatis.class);
			if (ret) {
				Mybatis mybatis = (Mybatis) getClass().getAnnotation(
						Mybatis.class);
				setNamespace(mybatis.namespace());
			} else {
				setNamespace(name);
			}
		}

	}

}
