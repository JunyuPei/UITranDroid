package ListExchange;

import java.util.ArrayList;

public class IOSList {
	int id;
	int exchangeID=0;
	String subID;
	String name=null;
	ArrayList<IOSList> subList=new ArrayList<IOSList>();
	
	public void setSubID(String subID){
		this.subID=subID;
	}
	
	public String getSubID(){
		return subID;
	}
	
	public void setExchangeID(int exchangeID){
		this.exchangeID=exchangeID;
	}
	
	public int getExchangeID(){
		return exchangeID;
	}
	
	public void setID(int id){
		this.id=id;
	}
	
	public int getID(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void addList(IOSList iosList){
		subList.add(iosList);
	}
	
	public ArrayList<IOSList> getSubList(){
		return subList;
	}
}
