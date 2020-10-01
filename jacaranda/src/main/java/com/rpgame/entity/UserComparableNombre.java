package com.rpgame.entity;

import java.util.Comparator;

public class UserComparableNombre implements Comparator<User>{

	@Override
	public int compare(User arg0, User arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
