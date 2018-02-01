package IOS;

public class Connection {
	String name=null;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String property=null;
	String destination=null;
	String id=null;
		
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		System.out.print("Connection ");
		if(name!=null)System.out.print(" name:"+name);
		if(property!=null)System.out.print(" property:"+property);
		if(destination!=null)System.out.print(" destination:"+destination);
		if(id!=null)System.out.print(" id:"+id);
		System.out.println();
	}

}
