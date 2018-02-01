package com.imbarpjy.iOS;

import java.util.ArrayList;

public class iOSControl {
	//this is id, personal for one control
	int id = 0;
	//this is the attributes
	String name = null;
	String type = null;
	boolean enabled = false;
	boolean visible = false;
	String label = null;
	int x = 0, y = 0, width = 0, height = 0;
	//this is sub controls list
	ArrayList<iOSControl> subControlList = new ArrayList<iOSControl>();
	// this is the transformed Android control' id
	int relatedAndroidId = 0;
	// whether to be the head of one Module
	boolean beModelhead=false;
	
	public iOSControl(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ArrayList<iOSControl> getSubControlList() {
		return subControlList;
	}
	public void setSubControlList(ArrayList<iOSControl> subControlList) {
		this.subControlList = subControlList;
	}
	public void addSubControl(iOSControl iosControl) {
		this.subControlList.add(iosControl);
	}
	public int getRelatedAndroidId() {
		return relatedAndroidId;
	}
	public void setRelatedAndroidId(int relatedAndroidId) {
		this.relatedAndroidId = relatedAndroidId;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isBeModelhead() {
		return beModelhead;
	}
	public void setBeModelhead(boolean beModelhead) {
		this.beModelhead = beModelhead;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean beFunction() {
		if(subControlList.size() == 0)
			return true;
		return false;
	}
	
	
	public void print(int num){
		for(int i = 0; i < num; i++)
			System.out.print("    ");
		if(!isBeModelhead()) System.out.println(id+" " + type + " "+relatedAndroidId+" "+x+" "+y+" "+width+" "+height);
		else 	System.out.println("module:  "+id+" "+type+" "+relatedAndroidId+" "+x+" "+y+" "+width+" "+height);
		for(int i = 0; i < subControlList.size(); i++)
			subControlList.get(i).print(num+1);
	}
}
