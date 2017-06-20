package model;

import java.io.Serializable;

public class Seminar implements Serializable {

	private int sub_id;
	private int stu_id;

	public Seminar(){}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}


}
