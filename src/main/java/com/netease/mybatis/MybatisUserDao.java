package com.netease.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.netease.SpringJDBC.Users;

public interface MybatisUserDao {
	@Select("select * from users where first_name=#{firstName}")
	public Users getUser(String firstName);

	@Results({ @Result(property = "id", column = "id"), @Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	@Select("Select * from users")
	public List<Users> getUsers();
}
