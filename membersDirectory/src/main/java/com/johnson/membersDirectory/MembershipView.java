package com.johnson.membersDirectory;

import java.util.ArrayList;

import javax.validation.Valid;

public class MembershipView {
	
	@Valid
	private ArrayList<Membership> membershipList = new ArrayList<Membership>();
	
	public MembershipView() {}
	
	public MembershipView(ArrayList<Membership> membershipList) {
		this.membershipList = membershipList;
	}

	public ArrayList<Membership> getMembershipList() {
		return membershipList;
	}

	public void setMembershipList(ArrayList<Membership> membershipList) {
		this.membershipList = membershipList;
	}

}
