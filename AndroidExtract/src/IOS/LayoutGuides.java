package IOS;

public class LayoutGuides {
	String type=null;
	String id=null;
	
	public void setType(String typethis){
		type=typethis;
	}
	
	public void setID(String idThis){
		id=idThis;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.println("viewControllerLayoutGuide type:"+type+" id:"+id);
	}
}
