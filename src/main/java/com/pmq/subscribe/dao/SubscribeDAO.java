package com.pmq.subscribe.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
}
