package IOS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import javax.jws.Oneway;

public class IOSRead {
	
	ArrayList<ViewForIOS> viewListForIOS=new ArrayList<ViewForIOS>();

	public IOSRead( ) throws Exception {
//		 TODO Auto-generated method stub
		InputStreamReader is = new InputStreamReader(new FileInputStream("Main.storyboard"), "UTF-8");		 
		BufferedReader br = new BufferedReader(is);  
		String line = br.readLine();
		String oneScene="",sceneID="";
		ViewForIOS view=null;
		int state=0;
		while (line != null) {
			if(line.contains("<scene")&&!line.contains("<scenes")&&state==0){
				state=1;
				view=new ViewForIOS();
				sceneID=line.split("=")[1].split("\"")[1];
				view.setSceneID(sceneID);
			}
			else if(line.contains("Controller")&&state==1){
				state=2;
				String[] words=line.split(" ");
				for(int j=1;j<words.length;j++){
					if(words[j].split("=").length<2)continue;
					String a=words[j].split("=")[0];
					if(words[j].split("=")[1].split("\"").length<2)continue;
					String b=words[j].split("=")[1].split("\"")[1];
					if(a.compareTo("storyboardIdentifier")==0)
						view.setStoryboardIdentifier(b);
					if(a.compareTo("hidesBottomBarWhenPushed")==0)
						view.setHidesBottomBarWhenPushed(b);
					if(a.compareTo("id")==0)
						view.setControlID(b);
					if(a.compareTo("customClass")==0)
						view.setCustomClass(b);
					if(a.compareTo("sceneMemberID")==0)
						view.setMemID(b);
				}
			}
			else if(line.contains("<viewControllerLayoutGuide")&&state==2){
				LayoutGuides layoutGuide=new LayoutGuides();
				layoutGuide.setType(line.split("=")[1].split("\"")[1]);
				layoutGuide.setID(line.split("=")[2].split("\"")[1]);
				view.addLayoutGuide(layoutGuide);
			}
			else if(line.contains("<placeholder")&&state==2){
				state=3;
				Placeholder placeholder=new Placeholder();
				line=line.substring(line.indexOf("placeholderIdentifier"));
				placeholder.setPlaceholderIdentifier(line.split("=")[1].split("\"")[1]);
				line=line.substring(line.indexOf("id"));
				placeholder.setID(line.split("=")[1].split("\"")[1]);
				if(line.contains("userLabel")){
					line=line.substring(line.indexOf("userLabel"));
					placeholder.setUserLabel(line.split("=")[1].split("\"")[1]);
				}
				line=line.substring(line.indexOf("sceneMemberID"));
				placeholder.setSceneMemberID(line.split("=")[1].split("\"")[1]);
				view.addPlaceholder(placeholder);
			}
			else if(line.contains("</objects>")&&state==3){
				state=4;
				view.setControls(dealScene(oneScene));
				viewListForIOS.add(view);
				oneScene="";
			}
			else if(line.contains("<point")&&state==4){
				state=0;
				double pointX=Double.parseDouble(line.split("=")[2].split("\"")[1]);
				double pointY=Double.parseDouble(line.split("=")[3].split("\"")[1]);
				view.setPointX(pointX);
				view.setPointY(pointY);
			}
			else if(state==2)
				oneScene+=line;
			line = br.readLine();
		}
		
	}
	
	public ArrayList<ControlForIOS> dealScene(String word){
		String[] sentence=word.split("<");
		String subword="";
		ArrayList<ControlForIOS> controls=new ArrayList<ControlForIOS>();
		Map<String,String> map=new ControlsMap().getMap();
		for(int i=0;i<sentence.length;i++){
			for(Map.Entry<String, String> entry:map.entrySet()){  
				if(sentence[i].startsWith(entry.getKey())&&!sentence[i].contains("/>")){
					int temp = 1;
					subword+="<";
					subword+=sentence[i];
					i++;
					for(;i<sentence.length&&temp>0;i++){
						if(sentence[i].startsWith(entry.getKey())) temp++;
						if(sentence[i].startsWith(entry.getValue())) temp--;
						subword+="<";
						subword+=sentence[i];
					}
					ControlForIOS conthis=dealControl(subword);
					conthis.setName(entry.getKey());
					controls.add(conthis);
					subword="";
					break;
				}
				else if(sentence[i].startsWith(entry.getKey())&&sentence[i].contains("/>")){
					ControlForIOS conthis=dealControl("<"+sentence[i]);
					conthis.setName(entry.getKey());
					controls.add(conthis);
					subword="";
					break;
				}
			}
		}
		return controls;
	}
	
	public ControlForIOS dealControl(String word){
		ControlForIOS controlForIOS=new ControlForIOS();
		controlForIOS.setRect(new Rect());
		String[] sentence=word.split("<");
		if(sentence.length>=2){
			String[] words=sentence[1].split(" ");
			for(int j=1;j<words.length;j++){
				if(words[j].split("=").length<2)continue;
				String a=words[j].split("=")[0];
				String b=null;
				if(words[j].split("=")[1].split("\"").length>=2)b=words[j].split("=")[1].split("\"")[1];
				else b=words[j].split("=")[1];
				if(a.compareTo("key")==0)
					controlForIOS.setKey(b);
				if(a.compareTo("title")==0)
					controlForIOS.setTitle(b);
				if(a.compareTo("userInteractionEnabled")==0)
					controlForIOS.setUserInteractionEnabled(b);
				if(a.compareTo("horizontalHuggingPriority")==0)
					controlForIOS.setHorizontalHuggingPriority(b);
				if(a.compareTo("verticalHuggingPriority")==0)
					controlForIOS.setVerticalHuggingPriority(b);
				if(a.compareTo("image")==0)
					controlForIOS.setImage(b);
				if(a.compareTo("translatesAutoresizingMaskIntoConstraints")==0)
					controlForIOS.setTranslatesAutoresizingMaskIntoConstraints(b);
				if(a.compareTo("multipleTouchEnabled")==0)
					controlForIOS.setMultipleTouchEnabled(b);
				if(a.compareTo("clipsSubviews")==0)
					controlForIOS.setClipsSubviews(b);
				if(a.compareTo("userLabel")==0)
					controlForIOS.setUserLabel(b);
				if(a.compareTo("placeholder")==0)
					controlForIOS.setPlaceholder(b);
				if(a.compareTo("backgroundImage")==0)
					controlForIOS.setBackgroundImage(b);
				if(a.compareTo("contentMode")==0)
					controlForIOS.setContentMode(b);
				if(a.compareTo("id")==0)
					controlForIOS.setId(b);
				if(a.compareTo("style")==0)
					controlForIOS.setStyle(b);
				if(a.compareTo("rowHeight")==0)
					controlForIOS.setRowHeight(b);
				if(a.compareTo("sectionHeaderHeight")==0)
					controlForIOS.setSectionHeaderHeight(b);
				if(a.compareTo("sectionFooterHeight")==0)
					controlForIOS.setSectionFooterHeight(b);
				if(a.compareTo("text")==0)
					controlForIOS.setText(b);
				if(a.compareTo("alwaysBounceVertical")==0)
					controlForIOS.setAlwaysBounceVertical(b);
				if(a.compareTo("dataMode")==0)
					controlForIOS.setDataMode(b);
				if(a.compareTo("separatorStyle")==0)
					controlForIOS.setSeparatorStyle(b);
				if(a.compareTo("opaque")==0)
					controlForIOS.setOpaque(b);
				if(a.compareTo("contentHorizontalAlignment")==0)
					controlForIOS.setContentHorizontalAlignment(b);
				if(a.compareTo("contentVerticalAlignment")==0)
					controlForIOS.setContentVerticalAlignment(b);
				if(a.compareTo("buttonType")==0)
					controlForIOS.setButtonType(b);
				if(a.compareTo("lineBreakMode")==0)
					controlForIOS.setLineBreakMode(b);
				if(a.compareTo("textAlignment")==0)
					controlForIOS.setTextAlignment(b);
				if(a.compareTo("hidden")==0)
					controlForIOS.setHidden(b);
				if(a.compareTo("showsHorizontalScrollIndicator")==0)
					controlForIOS.setShowsHorizontalScrollIndicator(b);
				if(a.compareTo("showsVerticalScrollIndicator")==0)
					controlForIOS.setShowsVerticalScrollIndicator(b);
				if(a.compareTo("editable")==0)
					controlForIOS.setEditable(b);
				if(a.compareTo("footerTitle")==0)
					controlForIOS.setFooterTitle(b);
			}
		}
		for(int i=2;i<sentence.length;i++){
			if(sentence[i].startsWith("rect")||sentence[i].startsWith("frame")){
				Rect rect=new Rect();
				String[] words=sentence[i].split(" ");
				for(int j=1;j<words.length;j++){
					if(words[j].split("=").length<2)continue;
					String a=words[j].split("=")[0];
					String b=null;
					if(words[j].split("=")[1].split("\"").length>=2)b=words[j].split("=")[1].split("\"")[1];
					else b=words[j].split("=")[1];
					if(a.compareTo("key")==0)
						rect.setKey(b);
					if(a.compareTo("x")==0)
						rect.setX(b);
					if(a.compareTo("y")==0)
						rect.setY(b);
					if(a.compareTo("width")==0)
						rect.setWidth(b);
					if(a.compareTo("height")==0)
						rect.setHeight(b);
				}
				controlForIOS.setRect(rect);
			}
			else if(sentence[i].startsWith("autoresizingMask")){
				AutoresizingMask autoresizingMask=new AutoresizingMask();
				if(sentence[i].contains("key")){
					sentence[i]=sentence[i].substring(sentence[i].indexOf("key"));
					autoresizingMask.setKey(sentence[i].split("=")[1].split("\"")[1]);
				}
				if(sentence[i].contains("flexibleMaxX")){
					sentence[i]=sentence[i].substring(sentence[i].indexOf("flexibleMaxX"));
					autoresizingMask.setflexibleMaxX(sentence[i].split("=")[1].split("\"")[1]);
				}
				if(sentence[i].contains("flexibleMaxY")){
					sentence[i]=sentence[i].substring(sentence[i].indexOf("flexibleMaxY"));
					autoresizingMask.setflexibleMaxY(sentence[i].split("=")[1].split("\"")[1]);
				}
				controlForIOS.setAutoresizingMask(autoresizingMask);
			}
			else if(sentence[i].startsWith("color")){
				Color color=new Color();
				String[] words=sentence[i].split(" ");
				for(int j=1;j<words.length;j++){
					if(words[j].split("=").length<2)continue;
					String a=words[j].split("=")[0];
					String b=null;
					if(words[j].split("=")[1].split("\"").length>=2)b=words[j].split("=")[1].split("\"")[1];
					else b=words[j].split("=")[1];
					if(a.compareTo("key")==0)
						color.setKey(b);
					if(a.compareTo("red")==0)
						color.setRed(b);
					if(a.compareTo("green")==0)
						color.setGreen(b);
					if(a.compareTo("blue")==0)
						color.setBlue(b);
					if(a.compareTo("white")==0)
						color.setWhite(b);
					if(a.compareTo("alpha")==0)
						color.setAlpha(b);
					if(a.compareTo("colorSpace")==0)
						color.setColorSpace(b);
					if(a.compareTo("customColorSpace")==0)
						color.setCustomColorSpace(b);
				}
				controlForIOS.addColor(color);
			}
			else if(sentence[i].startsWith("fontDescription")){
				FontDescription fontDescription=new FontDescription();
				String[] words=sentence[i].split(" ");
				for(int j=1;j<words.length;j++){
					if(words[j].split("=").length<2)continue;
					String a=words[j].split("=")[0];
					String b=null;
					if(words[j].split("=")[1].split("\"").length>=2)b=words[j].split("=")[1].split("\"")[1];
					else b=words[j].split("=")[1];
					if(a.compareTo("key")==0)
						fontDescription.setKey(b);
					if(a.compareTo("type")==0)
						fontDescription.setType(b);
					if(a.compareTo("pointSize")==0)
						fontDescription.setPointSize(b);
				}
				controlForIOS.setFontDescription(fontDescription);
			}
			else if(sentence[i].startsWith("constraint")&&!sentence[i].startsWith("constraints>")){
				Constraint constraint=new Constraint();
				String[] wordss=sentence[i].split(" ");
				for(int j=1;j<wordss.length;j++){
					if(wordss[j].split("=").length<2)continue;
					String a=wordss[j].split("=")[0];
					String b=wordss[j].split("=")[1].split("\"")[1];
					if(a.compareTo("firstItem")==0)
						constraint.setFirstItem(b);
					if(a.compareTo("firstAttribute")==0)
						constraint.setFirstAttribute(b);
					if(a.compareTo("secondItem")==0)
						constraint.setSecondItem(b);
					if(a.compareTo("secondAttribute")==0)
						constraint.setSecondAttribute(b);
					if(a.compareTo("id")==0)
						constraint.setID(b);
				}
				controlForIOS.addConstraint(constraint);
			}
			else if(sentence[i].startsWith("constraint")&&!sentence[i].startsWith("constraints>")){
				Constraint constraint=new Constraint();
				String[] wordss=sentence[i].split(" ");
				for(int j=1;j<wordss.length;j++){
					if(wordss[j].split("=").length<2)continue;
					String a=wordss[j].split("=")[0];
					String b=wordss[j].split("=")[1].split("\"")[1];
					if(a.compareTo("firstItem")==0)
						constraint.setFirstItem(b);
					if(a.compareTo("firstAttribute")==0)
						constraint.setFirstAttribute(b);
					if(a.compareTo("secondItem")==0)
						constraint.setSecondItem(b);
					if(a.compareTo("secondAttribute")==0)
						constraint.setSecondAttribute(b);
					if(a.compareTo("id")==0)
						constraint.setID(b);
				}
				controlForIOS.addConstraint(constraint);
			}
			else if(sentence[i].startsWith("connections")){
				i++;
				while(!sentence[i].startsWith("/connections")&&i<sentence.length){
					Connection connection=new Connection();
					String[] wordss=sentence[i].split(" ");
					connection.setName(wordss[0]);
					for(int j=1;j<wordss.length;j++){
						if(wordss[j].split("=").length<2)continue;
						String a=wordss[j].split("=")[0];
						String b=wordss[j].split("=")[1].split("\"")[1];
						if(a.compareTo("property")==0)
							connection.setProperty(b);
						if(a.compareTo("destination")==0)
							connection.setDestination(b);
						if(a.compareTo("id")==0)
							connection.setId(b);
					}
					controlForIOS.addConnection(connection);
					i++;
				}
			}
			else if(sentence[i].startsWith("state")){
				State state=new State();
				String[] wordss=sentence[i].split(" ");
				for(int j=1;j<wordss.length;j++){
					if(wordss[j].split("=").length<2)continue;
					String a=wordss[j].split("=")[0];
					if(wordss[j].split("=")[1].split("\"").length<2) continue;
					String b=wordss[j].split("=")[1].split("\"")[1];
					if(a.compareTo("key")==0)
						state.setKey(b);
					if(a.compareTo("image")==0)
						state.setImage(b);
					if(a.compareTo("backgroundImage")==0)
						state.setBackgroundImage(b);
					if(a.compareTo("title")==0)
						state.setTitle(b);
				}
				i++;
				while(i<sentence.length&&!sentence[i].startsWith("/state")){
					Color color=new Color();
					String[] words=sentence[i].split(" ");
					for(int j=1;j<words.length;j++){
						if(words[j].split("=").length<2)continue;
						String a=words[j].split("=")[0];
						String b=null;
						if(words[j].split("=")[1].split("\"").length>=2)b=words[j].split("=")[1].split("\"")[1];
						else b=words[j].split("=")[1];
						if(a.compareTo("key")==0)
							color.setKey(b);
						if(a.compareTo("red")==0)
							color.setRed(b);
						if(a.compareTo("green")==0)
							color.setGreen(b);
						if(a.compareTo("blue")==0)
							color.setBlue(b);
						if(a.compareTo("white")==0)
							color.setWhite(b);
						if(a.compareTo("alpha")==0)
							color.setAlpha(b);
						if(a.compareTo("colorSpace")==0)
							color.setColorSpace(b);
						if(a.compareTo("customColorSpace")==0)
							color.setCustomColorSpace(b);
					}
					state.addColor(color);
					i++;
				}
				controlForIOS.addState(state);
			}
			else{
				String subword="";			
				Map<String,String> map=new ControlsMap().getMap();
				for(Map.Entry<String, String> entry:map.entrySet()){
					if(sentence[i].startsWith(entry.getKey())&&!sentence[i].contains("/>")){
						int temp = 1;
						subword+="<";
						subword+=sentence[i];
						i++;
						for(;i<sentence.length;i++){
							if(sentence[i].startsWith(entry.getKey())&&!sentence[i].contains("/>")) temp++;
							if(sentence[i].startsWith(entry.getValue())) temp--;
							if(temp<1)break;
							subword+="<";
							subword+=sentence[i];
						}
						ControlForIOS conthis=dealControl(subword);
						conthis.setName(entry.getKey());
						controlForIOS.addControl(conthis);
						subword="";
						break;
					}
					else if(sentence[i].startsWith(entry.getKey())&&sentence[i].contains("/>")){
						ControlForIOS conthis=dealControl(sentence[i]);
						conthis.setName(entry.getKey());
						controlForIOS.addControl(conthis);
						subword="";
						break;
					}
				}
			}
			
		}
		return controlForIOS;	
	}
	
	public ArrayList<ViewForIOS> getView(){
		return viewListForIOS;
	}
	

}
