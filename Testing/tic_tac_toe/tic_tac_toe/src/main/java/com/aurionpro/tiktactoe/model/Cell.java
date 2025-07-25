package com.aurionpro.tiktactoe.model;

import com.aurionpro.tiktactoe.enums.Mark;

public class Cell {
	private Mark mark;

	public Cell( Mark mark) {
		this.mark = mark;
	}

	
	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

}
