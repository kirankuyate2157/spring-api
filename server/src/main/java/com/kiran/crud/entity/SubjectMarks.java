package com.kiran.crud.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectMarks {
    private long math;
    private long physics;
    private long chemistry;
    private long biology;
    private long marathi;
    private long english;

    
    
    
    public SubjectMarks(long math, long physics, long chemistry, long biology, long marathi, long english) {
		super();
		this.math = math;
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		this.marathi = marathi;
		this.english = english;
	}

	public SubjectMarks() {
		super();
		this.math = 0;
		this.physics = 0;
		this.chemistry = 0;
		this.biology = 0;
		this.marathi = 0;
		this.english = 0;
    }

	public long getMath() {
		return math;
	}

	public void setMath(long math) {
		this.math = math;
	}

	public long getPhysics() {
		return physics;
	}

	public void setPhysics(long physics) {
		this.physics = physics;
	}

	public long getChemistry() {
		return chemistry;
	}

	public void setChemistry(long chemistry) {
		this.chemistry = chemistry;
	}

	public long getBiology() {
		return biology;
	}

	public void setBiology(long biology) {
		this.biology = biology;
	}

	public long getMarathi() {
		return marathi;
	}

	public void setMarathi(long marathi) {
		this.marathi = marathi;
	}

	public long getEnglish() {
		return english;
	}

	public void setEnglish(long english) {
		this.english = english;
	}

	@Override
	public String toString() {
		return "SubjectMarks [math=" + math + ", physics=" + physics + ", chemistry=" + chemistry + ", biology="
				+ biology + ", marathi=" + marathi + ", english=" + english + "]";
	}

	

}
