package Android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControlForAndroid {
	Map<String,String> feature;
	ArrayList<ControlForAndroid> subControl;
	String nameOfControl;
	
	public ControlForAndroid(String name){
		nameOfControl=name;
		feature=new HashMap<String,String>();
		subControl=new ArrayList<ControlForAndroid>();
	}
	
	public void addFeature(String featureIn,String value){
		feature.put(featureIn, value);
	}
	
	public void addControl(ControlForAndroid control){
		subControl.add(control);
	}
	
	public String getName(){
		return nameOfControl;
	}
	
	public void setName(String name){
		nameOfControl=name;
	}
	
	public ArrayList<ControlForAndroid> getSubControl(){
		return subControl;
	}
	
	public Map<String,String> getFeature(){
		return feature;
	}

	public void print(int num){
		for(int j=0;j<num;j++)
			System.out.print("    ");
		System.out.println(nameOfControl);
		for (Object key : feature.keySet()) {
			for(int j=0;j<num+1;j++)
				System.out.print("    ");
			System.out.println(key + " :" + feature.get(key));
		}
		for(int k=0;k<subControl.size();k++)
			subControl.get(k).print(num+1);
	}
}
