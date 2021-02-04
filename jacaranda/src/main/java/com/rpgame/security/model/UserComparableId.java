package com.rpgame.security.model;

import java.util.Comparator;

public class UserComparableId implements Comparator<User> {

	@Override
	public int compare(User arg0, User arg1) {
		// TODO Auto-generated method stub
		if (arg0.getId() > arg1.getId()) {
			return 1;
		} else if (arg0.getId() == arg1.getId()) {
			return 0;
		} else {
			return -1;
		}
	}

}
