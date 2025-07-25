package com.aurionpro.tiktactoe.model;

import com.aurionpro.tiktactoe.enums.Mark;

public class Player {
	private String name;
	private Mark mark;


	public Player(Mark mark,String name) {
		super();
		this.mark = mark;
		this.name = name;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}
	
	

}
