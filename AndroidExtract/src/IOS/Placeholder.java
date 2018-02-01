package IOS;

public class Placeholder {
	String placeholderIdentifier=null;
	String id=null;
	String userLabel=null;
	String sceneMemberID=null;
	
	public void setPlaceholderIdentifier(String P){
		placeholderIdentifier=P;
	}
	
	public void setID(String I){
		id=I;
	}
	
	public void setUserLabel(String U){
		userLabel=U;
	}
	
	public void setSceneMemberID(String S){
		sceneMemberID=S;
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("Placeholder ");
		if(placeholderIdentifier!=null)System.out.print(" placeholderIdentifier:"+placeholderIdentifier);
		if(id!=null)System.out.print(" id:"+id);
		if(userLabel!=null)System.out.print(" userLabel:"+userLabel);
		if(sceneMemberID!=null)System.out.print(" sceneMemberID:"+sceneMemberID);
		System.out.println();
	}
}
