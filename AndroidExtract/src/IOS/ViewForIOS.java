package IOS;

import java.util.ArrayList;

public class ViewForIOS {
	String sceneID=null;
	ArrayList<ControlForIOS> controls;
	LayoutGuides[] layoutGuides;int numofLayout=0;
	String controlID=null;
	String controlMemID=null;
	String customClass=null;
	String storyboardIdentifier=null;
	String hidesBottomBarWhenPushed=null;
	double pointx=0,pointy=0;
	Placeholder placeholder=null;
	ArrayList<Connection> connections=new ArrayList<>();
	
	public ViewForIOS(){
		layoutGuides=new LayoutGuides[2];
		controls=new ArrayList<ControlForIOS>();
	}
	
	public void setControls(ArrayList<ControlForIOS> control){
		controls=control;
	}
	
	public void setPointX(double x){
		pointx=x;
	}
	
	public void setPointY(double y){
		pointy=y;
	}
	
	public void setSceneID(String id){
		sceneID=id;
	}
	
	public void setStoryboardIdentifier(String id){
		storyboardIdentifier=id;
	}
	
	public void setHidesBottomBarWhenPushed(String id){
		hidesBottomBarWhenPushed=id;
	}
	
	public void setControlID(String controlid){
		controlID=controlid;
	}
	
	public void setMemID(String memID){
		controlMemID=memID;
	}
	
	public void setCustomClass(String customclass){
		customClass=customclass;
	}
	
	public void addLayoutGuide(LayoutGuides layout){
		layoutGuides[numofLayout]=layout;
		numofLayout++;
	}
	
	public void addPlaceholder(Placeholder P){
		placeholder=P;
	}
	
	public void addConnection(Connection connect){
		connections.add(connect);
	}
	
	public ArrayList<ControlForIOS> getControls(){
		return controls;
	}
	
	public void print(){
		if(sceneID!=null)System.out.println("sceneID:"+sceneID);
		if(controlID!=null)System.out.print("  controlID:"+controlID);
		if(controlMemID!=null)System.out.print("  controlMemID:"+controlMemID);
		if(customClass!=null)System.out.print("  customClass:"+customClass);
		if(storyboardIdentifier!=null)System.out.print("  storyboardIdentifier:"+storyboardIdentifier);
		if(hidesBottomBarWhenPushed!=null)System.out.print("  hidesBottomBarWhenPushed:"+hidesBottomBarWhenPushed);
		System.out.println();
		for(int i=0;i<numofLayout;i++)
			layoutGuides[i].print(1);
		for(int i=0;i<controls.size();i++)
			controls.get(i).print(1);
		for(int i=0;i<connections.size();i++)
			connections.get(i).print(1);
		placeholder.print(0);
		if(pointx!=0||pointy!=0)System.out.println("point pointx:"+pointx+" pointy:"+pointy);
	}
}
