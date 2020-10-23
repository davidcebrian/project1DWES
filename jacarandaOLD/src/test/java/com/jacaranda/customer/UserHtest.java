package com.jacaranda.customer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.rpgame.entity.User;
import com.rpgame.entity.UserComparableId;
import com.rpgame.entity.UserComparableNombre;

class UserHtest {

	private List<User> customers = new ArrayList<> ();
	
	@Test
	public void testFailOnNull() {
		List<User> customers = null;
		
		try {
			customers.stream().sorted();
		}catch(Exception e) {
			assert(true);
		}
	}
	
	@Test
	public void testFailOnEmpty() {
		List<User> vacio = new ArrayList<User>();
		try {
			vacio.sort(new UserComparableId());
			assert(true);
		}catch(Exception e) {
			assert(false);
		}
	}
	
	@Test
	public void testOrderedCollection() {	
		customers.sort(new UserComparableNombre());
		
	}

}
