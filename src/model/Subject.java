package model;

import java.io.Serializable;

public class Subject implements Serializable{

	private int sub_id;
	private String sub_name;
	private String sub_group;
	private int tea_id;

	public Subject(){}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	public String getSub_group() {
		return sub_group;
	}

	public void setSub_group(String sub_group) {
		this.sub_group = sub_group;
	}

	public int getTea_id() {
		return tea_id;
	}

	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}


}
