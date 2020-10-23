package com.rpgame.entity;

import java.util.Comparator;

public class AtaqueComparable implements Comparator<Ataque>{

	@Override
	public int compare(Ataque arg0, Ataque arg1) {
		// TODO Auto-generated method stub
		return Integer.valueOf(arg0.getIdAtaque()).compareTo(arg1.getIdAtaque());
	}

}
