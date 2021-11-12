package com.pmq.publication.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmq.subscribe.bo.InterestBO;
import com.pmq.subscribe.model.InterestView;

@Service
public class MailBO {
	
	@Autowired
	private InterestBO interestBO;
	
	public void sendMail(int loginUserId) {
		
		ArrayList<String> userAddressList = new ArrayList<>();
		
		List<InterestView> interestViewList = interestBO.generateInterestViewList(loginUserId);
		for (InterestView interest : interestViewList) {
			for() // i ~ interestSize만큼 돌면서,  userAddressList에 set하기 그것을 마지막에 add
		}
		
	
	}
}
