package ListExchange;

import java.util.ArrayList;

import IOS.ControlForIOS;

public class AndroidList {
	int id;
	int exchangeID=0;
	String subID=null;
	String name=null;
	ArrayList<AndroidList> subList=new ArrayList<AndroidList>();
	ControlForIOS controlForIOS=new ControlForIOS();
	
	public AndroidList get(int exchangeID){
		if(id==exchangeID)return this;
		for(int i=0;i<subList.size();i++){
			if(subList.get(i).getID()==exchangeID)
				return subList.get(i);
			if(subList.get(i).get(exchangeID)!=null)
				return subList.get(i).get(exchangeID);
		}
		return null;
	}
	
	public ControlForIOS getControlForIOS() {
		return controlForIOS;
	}

	public void setControlForIOS(ControlForIOS controlForIOS) {
		this.controlForIOS = controlForIOS;
	}

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
	
	public void addList(AndroidList androidList){
		subList.add(androidList);
	}
	
	public ArrayList<AndroidList> getSubList(){
		return subList;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.println(name+" "+controlForIOS.getName());
		for(int i=0;i<subList.size();i++)
			subList.get(i).print(num+1);
	}
}
