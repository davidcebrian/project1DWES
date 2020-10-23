package com.rpgame.entity;

import java.util.Comparator;

public class PersonajeComparable implements Comparator<Personaje>{

	@Override
	public int compare(Personaje arg0, Personaje arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}
	

}
