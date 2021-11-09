package com.pmq.subscribe.model;

import java.util.List;

import com.pmq.edition.model.Edition;
import com.pmq.like.model.Like;

public class InterestView {
	private Edition edition;
	private Subscribe subscribe;
	private Like like;
	
	public Edition getEdition() {
		return edition;
	}
	public void setEdition(Edition edition) {
		this.edition = edition;
	}
	
	public Subscribe getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}
	public Like getLike() {
		return like;
	}
	public void setLike(Like like) {
		this.like = like;
	}
	
}
