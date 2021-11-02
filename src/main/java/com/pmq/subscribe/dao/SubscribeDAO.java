package com.pmq.subscribe.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.pmq.subscribe.model.Subscribe;

@Repository
public interface SubscribeDAO {
	
	// select subscribe
	public int selectSubscribeByEditionIdOrUserId(
			@Param("userId") int userId,
			@Param("editionId") int editionId);
	
	// insert subscribe
	public void insertSubscribe(
			@Param("userId") int userId,
			@Param("userLoginId") String userLoginId,
			@Param("editionId") int editionId);
	
	// delete subscribe
	public void deleteSubscribe(
			@Param("userId") int userId,
			@Param("editionId") int editionId);
	
	// select subscribe List
	public List<Subscribe> selectSubscribeList(int editionId);
	
	// select subscribeListByUserId 
	public List<Subscribe> selectSubscribeListByUserId(int userId);
	
	// join
	public List<Map<String, Object>> selectSubscribeEdtionList();
}
