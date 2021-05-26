package com.ncu.dao;

import java.util.List;

import com.ncu.model.firstmodel;

public interface UserDao {
	 public void saveOrUpdate(firstmodel user);
     
	    public void delete(String eid);
	     
	    public firstmodel get(String eid);
	     
//	    public firstmodel get(String eid,);
	    public List<firstmodel> list();
	
}
