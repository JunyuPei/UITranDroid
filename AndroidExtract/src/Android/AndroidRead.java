package Android;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class AndroidRead {
	
	TreeForAndroid treeForAndroid=new TreeForAndroid();
	ControlForAndroid first;

	public AndroidRead( ) throws Exception {
//		 TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(new FileInputStream("details.xml"), "UTF-8");		 
		BufferedReader br = new BufferedReader(is);  
		String line = br.readLine();
		int begin=0,include=0,includeflag=0;;
		while (line != null) {
//			System.out.println(line);
			if(line.contains("/>"))includeflag=1;
			if(line.contains("<?")||line.contains("<!")){line = br.readLine();continue;}
			int popYoN=0;
			if(line.contains("<")&&!line.contains("</")){
				line=line.substring(line.indexOf("<")+1);
				if(line.contains("/>")){
					line=line.substring(0, line.indexOf("/>"));
					popYoN=1;
				}
				else if(line.contains(">"))
					line=line.substring(0, line.indexOf(">"));
				String[] contain=line.split(" ");
				int firstYoN=0;
				for(int i=0;i<contain.length;i++)
					if(contain[i]!=""){
						if(firstYoN==0&&include==0){include=getControl(contain[i]);firstYoN=1;}
						if(firstYoN==1&&include==0) getFeature(contain[i]);
					}
			}
			else{
				if(line.contains("</")){
					line=line.substring(line.indexOf("</")+1);
					popYoN=1;
				}
				if(line.contains("/>")){
					line=line.substring(0, line.indexOf("/>"));
					popYoN=1;
				}
				else if(line.contains(">"))
					line=line.substring(0, line.indexOf(">"));
				String[] contain=line.split(" ");
				for(int i=0;i<contain.length;i++)
					if(contain[i]!=""&&include==0)
						getFeature(contain[i]);
			}
			if(includeflag==1){include=0;includeflag=0;}
			if(popYoN==1)treeForAndroid.pop();
			line = br.readLine();
			if(begin==0){
				first=treeForAndroid.getRoot();
				begin=1;
			}
//			System.out.println(TreeForAndroid.getelementnum());
		}
	}
	
	public void getFeature(String element){
		String feature,value;
		if(!element.contains("=")||element.split(":").length>2)return;
		if(element.contains("style")){
			feature=element.split("=")[0];
			value=element.split("=")[1];
			treeForAndroid.getPre().addFeature(feature, value);
			return;
		}
		feature=element.split(":")[1].split("=")[0];
		value=element.split(":")[1].split("=")[1];
		value=value.substring(1, value.length()-1);
		treeForAndroid.getPre().addFeature(feature, value);
	}
	
	public int getControl(String element){
		ControlForAndroid newControl = new ControlForAndroid("");
		if(element.compareTo("LinearLayout")==0)
			newControl.setName("LinearLayout");
		else if(element.compareTo("ImageView")==0)
			newControl.setName("ImageView");
		else if(element.compareTo("View")==0)
			newControl.setName("View");
		else if(element.compareTo("RelativeLayout")==0)
			newControl.setName("RelativeLayout");
		else if(element.compareTo("ScrollView")==0)
			newControl.setName("ScrollView");
		else if(element.compareTo("include")==0){
			treeForAndroid.push(newControl);
			return 1;
		}
		else
			newControl.setName(element);
		if(!treeForAndroid.beEmpty())treeForAndroid.getPre().addControl(newControl);
		treeForAndroid.push(newControl);
		return 0;
	}
	
	public ControlForAndroid getAndroidRoot(){
		return first;
	}

}
