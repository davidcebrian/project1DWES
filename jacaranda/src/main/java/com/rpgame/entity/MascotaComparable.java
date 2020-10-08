package com.rpgame.entity;

import java.util.Comparator;

public class MascotaComparable implements Comparator<Mascota>{

	@Override
	public int compare(Mascota arg0, Mascota arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
