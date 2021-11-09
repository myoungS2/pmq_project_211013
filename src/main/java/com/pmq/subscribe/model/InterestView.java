package com.pmq.subscribe.model;

import java.util.List;

import com.pmq.edition.model.Edition;
import com.pmq.like.model.Like;

public class InterestView {
	private Edition edition;
	private List<Subscribe> subscribeList;
	private List<Like> likeList;
	
	public Edition getEdition() {
		return edition;
	}
	public void setEdition(Edition edition) {
		this.edition = edition;
	}
	public List<Subscribe> getSubscribeList() {
		return subscribeList;
	}
	public List<Like> getLikeList() {
		return likeList;
	}
	public void setLikeList(List<Like> likeList) {
		this.likeList = likeList;
	}
	public void setSubscribeList(List<Subscribe> subscribeList) {
		this.subscribeList = subscribeList;
	}
	
}
