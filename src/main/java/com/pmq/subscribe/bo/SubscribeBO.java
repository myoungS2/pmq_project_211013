package com.pmq.subscribe.bo;

import org.springframework.stereotype.Service;

import com.pmq.subscribe.dao.SubscribeDAO;

@Service
public class SubscribeBO {
	
	// SubscribeDAO 연결
	private SubscribeDAO subscribeDAO;
	
	// insert subscribe
	public void addOrDelSubscribe(int userId, String userLoginId, int editionId) {
		
		boolean existSubscribe = existSubscribe(userId, editionId);
		
		if (existSubscribe != true) {
			// 구독 중이지 않을 때 -> insert DB
			subscribeDAO.insertSubscribe(userId, userLoginId, editionId);
		}
	}
	
	// exist subscribe -> 구독 여부
	public boolean existSubscribe(int userId, int editionId) {
		int count = subscribeDAO.selectSubscribeByEditionIdOrUserId(userId, editionId);
		return count > 0? true: false;
	}
	
	
}
