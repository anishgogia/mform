package com.ncu.dao;

import java.util.List;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ncu.model.firstmodel;
@Repository
public class UserDaoimp implements UserDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public UserDaoimp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	@Override
	public void saveOrUpdate(firstmodel user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String eid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public firstmodel get(String eid) {
		
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM login where eid='" + eid + "'";
	    return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(firstmodel.class));
		
	}

	@Override
	public List<firstmodel> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
