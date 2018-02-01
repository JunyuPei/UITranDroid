package ListExchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import IOS.ControlForIOS;
import PageDivided.ModelForIOS;

public class ListRead {
	
	Map<IOSList,AndroidList> ListMap=new HashMap<IOSList,AndroidList>();
	
	public ListRead() throws Exception{	
		String path="controlList/";
		int i=1;
		File file=new File(path+"Android"+i+".txt");	
		while(file.exists()){
			ArrayList<AndroidList> androidList=AndroidRead(i);
			ArrayList<IOSList> iosList=IOSRead(i);
			for(int j=0;j<iosList.size();j++){
				int exchangeID=iosList.get(j).getExchangeID();
				if(exchangeID!=0)
					androidList.get(exchangeID-1).setExchangeID(j+1);
			}
			ListMap.put(iosList.get(0), androidList.get(0));
		    i++;
		    file=new File(path+"Android"+i+".txt");	
		} 
	}
	
	public ArrayList<AndroidList> AndroidRead(int i) throws Exception{
		ArrayList<AndroidList> android=new ArrayList<AndroidList>();
		String filename="controlList/Android"+i+".txt";	
		InputStreamReader is = new InputStreamReader(new FileInputStream(filename), "UTF-8");			 
		BufferedReader br = new BufferedReader(is);  
		String line = br.readLine();
		while (line != null) {			
			String[] words=line.split(" ");
			AndroidList androidList=new AndroidList();
			androidList.setID(Integer.parseInt(words[0]));
			androidList.setName(words[1]);
			if(words.length>2)
				androidList.setSubID(words[2]);
			android.add(androidList);
			line = br.readLine();
		}
		for(int j=0;j<android.size();j++){
			String subID=android.get(j).getSubID();
			if(subID==null)continue;		
			String[] subIDs=subID.split("\\|");
			for(int k=0;k<subIDs.length;k++){
				if(Integer.parseInt(subIDs[k])-1>=0)
					android.get(j).addList(android.get(Integer.parseInt(subIDs[k])-1));
			}
		}
		return android;
	}
	
	public ArrayList<IOSList> IOSRead(int i) throws Exception{
		ArrayList<IOSList> ios=new ArrayList<IOSList>();
		String filename="controlList/IOS"+i+".txt";	
		InputStreamReader is = new InputStreamReader(new FileInputStream(filename), "UTF-8");			 
		BufferedReader br = new BufferedReader(is);  
		String line = br.readLine();
		while (line != null) {			
			String[] words=line.split(" ");
			IOSList iosList=new IOSList();
			iosList.setID(Integer.parseInt(words[0]));
			iosList.setName(words[1]);
			iosList.setSubID(words[2]);
			if(words.length>3)
				iosList.setExchangeID(Integer.parseInt(words[3]));
			ios.add(iosList);
			line = br.readLine();
		}
		for(int j=0;j<ios.size();j++){
			String subID=ios.get(j).getSubID();
			String[] subIDs=subID.split("\\|");
			for(int k=0;k<subIDs.length;k++)
				if(Integer.parseInt(subIDs[k])>0)
					ios.get(j).addList(ios.get(Integer.parseInt(subIDs[k])-1));
		}
		return ios;
	}
	
	public Map<IOSList,AndroidList> getMap(){
		return ListMap;
	}
	
	public AndroidList Exchange(ModelForIOS model){
		int num=1;
		for(Map.Entry<IOSList, AndroidList> entry:ListMap.entrySet()){ 
			
			if(equal(entry.getKey(),entry.getValue(),model.getControl(),num))
				return entry.getValue();
			num++;
		}
		return null;
	}
		
	public boolean equal(IOSList iosList,AndroidList androidList,ControlForIOS control,int num){
		if(!iosList.getName().equals(control.getName().replace(" ", ""))){
//			System.out.println("aaaaaaaa"+num+" "+iosList.getID()+" "+iosList.getName()+" "+control.getName()+" "+control.getId());
			return false;
		}
		for(int i=0;i<iosList.getSubList().size();i++){
			int flag=0;
			for(int j=0;j<control.getSubControl().size();j++){
				if(control.getSubControl().get(j).isCorreState()){continue;}
				if(iosList.getSubList().get(i).getName().startsWith("model")&&control.getSubControl().get(j).getModelname()!=null&&control.getSubControl().get(j).getModelname().startsWith("model")){
					androidList.get(iosList.getSubList().get(i).getExchangeID()).setControlForIOS(control.getSubControl().get(j));
					control.getSubControl().get(j).setCorreState(true);
					flag=1;
					break;
				}
				else if(!iosList.getSubList().get(i).getName().startsWith("model")){
					if(control.getSubControl().get(j).getModelname()!=null&&control.getSubControl().get(j).getModelname().startsWith("model"))
						continue;
					if(equal(iosList.getSubList().get(i), androidList, control.getSubControl().get(j),num)){
						flag=1;
						break;
					}
				}
			}
			if(flag==0){
				for(int h=0;h<control.getSubControl().size();h++){
					control.getSubControl().get(h).setCorreState(false);
				}
//				System.out.println("bbbbbbbb"+num+" "+iosList.getID()+" "+iosList.getName()+" "+control.getName()+" "+control.getId());
				return false;
			}
		}
		for(int i1=0;i1<control.getSubControl().size();i1++){
			if(!control.getSubControl().get(i1).isCorreState()){
				for(int h=0;h<control.getSubControl().size();h++){
					control.getSubControl().get(h).setCorreState(false);
				}		
//				System.out.println("cccccccc"+num+" "+iosList.getID()+" "+iosList.getName()+" "+control.getName()+" "+control.getId());
				return false;
			}
		}
		if(androidList!=null){
			System.out.println(iosList.getID()+" "+iosList.getName()+" "+control.getName()+" "+control.getId());
			if(iosList.getExchangeID()!=0)
				androidList.get(iosList.getExchangeID()).setControlForIOS(control);
			control.setCorreState(true);
		}
		return true;
	}
	
//	public boolean equal(IOSList iosList,AndroidList androidList,ControlForIOS control){
//		if(!iosList.getName().equals(control.getName().replace(" ", "")))
//			return false;
//		int modelOfiosList=0,modelOfControl=0;
//		for(int i=0;i<iosList.getSubList().size();i++){
//			if(iosList.getSubList().get(i).getName().startsWith("model")){
//				modelOfiosList++;
//				continue;
//			}
//			int flag=0;
//			for(int j=0;j<control.getSubControl().size();j++){
//				if(control.getSubControl().get(j).getModelname()!=null&&control.getSubControl().get(j).getModelname().startsWith("model"))
//					continue;
//				if(equal(iosList.getSubList().get(i),androidList.get(iosList.getSubList().get(i).getExchangeID()), control.getSubControl().get(j)))
//					flag=1;
//			}
//			if(flag==0)return false;
//		}
//		for(int i=0;i<control.getSubControl().size();i++){
//			if(control.getSubControl().get(i).getModelname()!=null&&control.getSubControl().get(i).getModelname().startsWith("model")){
//				modelOfControl++;
//				continue;
//			}
//			int flag=0;
//			for(int j=0;j<iosList.getSubList().size();j++){
//				if(iosList.getSubList().get(j).getName().startsWith("model"))
//					continue;
//				if(equal(iosList.getSubList().get(j),androidList.get(iosList.getSubList().get(j).getExchangeID()), control.getSubControl().get(i)))
//					flag=1;
//			}
//			if(flag==0)return false;
//		}
//		if(modelOfControl!=modelOfiosList)return false;
//		if(androidList!=null)
//			androidList.setControlForIOS(control);
//		ArrayList<AndroidList> subList=androidList.getSubList();
//		ArrayList<ControlForIOS> subControl=control.getSubControl();
//		int i=0,j=0;
//		if(modelOfControl==0)return true;
//		while(i<subList.size()&&j<subControl.size()){
//			while(!subList.get(i).getName().startsWith("model"))i++;
//			while(!(subControl.get(j).getModelname()!=null&&subControl.get(j).getModelname().startsWith("model")))j++;
//			subList.get(i).setControlForIOS(subControl.get(j));
//			i++;j++;
//		}
//		return true;
//	}
}
