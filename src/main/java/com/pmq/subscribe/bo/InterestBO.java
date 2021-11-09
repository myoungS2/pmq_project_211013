package com.pmq.subscribe.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmq.edition.bo.EditionBO;
import com.pmq.edition.model.Edition;
import com.pmq.like.bo.LikeBO;
import com.pmq.subscribe.model.InterestView;
import com.pmq.subscribe.model.Subscribe;

@Service
public class InterestBO {
	// EditionBO
	@Autowired
	private EditionBO editionBO;
	
	// SubscribeBO
	@Autowired
	private SubscribeBO subscribeBO;
	
	// LikeBO?
	@Autowired
	private LikeBO likeBO;
	
	// edition 가져오기
	public List<InterestView> generateInterestViewList(int loginUserId){
			
			List<Edition> editionList = ;
			for (Subscribe subscribe: subscribeList) {
				// 구독중인 1개의 edition과 맵핑 될 insertest 만들기
				InterestView interest = new InterestView();
				
				interest.setEdition(edition);
				
				Edition subscribeEdition = editionBO.getEdition(subscribe.getEditionId());
			
				
			}
	}
}
