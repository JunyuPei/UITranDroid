package IOS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ControlForIOS {
	String name=null;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	boolean correState=false;
	public boolean isCorreState() {
		return correState;
	}

	public void setCorreState(boolean correState) {
		this.correState = correState;
	}

	String key=null;
	String title=null;//tabBarItem
	String userInteractionEnabled=null;//imageView.label
	String horizontalHuggingPriority=null;//imageView.label
	String verticalHuggingPriority=null;//imageView.label
	String image=null;//imageView
	String translatesAutoresizingMaskIntoConstraints=null;
	String multipleTouchEnabled=null;
	String clipsSubviews=null;
	String userLabel=null;
	String placeholder=null;//searchBar
	String backgroundImage=null;//searchBar
	String contentMode=null;
	String id=null;
	String style=null;
	String rowHeight=null;
	String sectionHeaderHeight=null;
	String sectionFooterHeight=null;
	String text=null;
	String textAlignment=null;
	String hidden=null;
	String showsHorizontalScrollIndicator=null;
	String showsVerticalScrollIndicator=null;
	String editable=null;
	String footerTitle=null;
	public String getFooterTitle() {
		return footerTitle;
	}

	public void setFooterTitle(String footerTitle) {
		this.footerTitle = footerTitle;
	}

	public String getShowsHorizontalScrollIndicator() {
		return showsHorizontalScrollIndicator;
	}

	public void setShowsHorizontalScrollIndicator(
			String showsHorizontalScrollIndicator) {
		this.showsHorizontalScrollIndicator = showsHorizontalScrollIndicator;
	}

	public String getShowsVerticalScrollIndicator() {
		return showsVerticalScrollIndicator;
	}

	public void setShowsVerticalScrollIndicator(String showsVerticalScrollIndicator) {
		this.showsVerticalScrollIndicator = showsVerticalScrollIndicator;
	}

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getTextAlignment() {
		return textAlignment;
	}

	public void setTextAlignment(String textAlignment) {
		this.textAlignment = textAlignment;
	}

	String alwaysBounceVertical=null;
	String dataMode=null;
	String separatorStyle=null;
	String opaque=null;															
	String contentHorizontalAlignment=null;
	String contentVerticalAlignment=null;
	String buttonType=null;
	String lineBreakMode=null;
	ArrayList<ControlForIOS> subcontrols=new ArrayList<ControlForIOS>();
	Rect rect=null;
	AutoresizingMask autoresizingMask=null;
	FontDescription fontDescription=null;
	public FontDescription getFontDescription() {
		return fontDescription;
	}

	public void setFontDescription(FontDescription fontDescription) {
		this.fontDescription = fontDescription;
	}
	ArrayList<State> states=new ArrayList<State>();
	public ArrayList<State> getStates() {
		return states;
	}

	public void addState(State state) {
		states.add(state);
	}

	ArrayList<Color> colors=new ArrayList<Color>();
	ArrayList<Constraint> constraints=new ArrayList<Constraint>();
	ArrayList<Connection> connections=new ArrayList<Connection>();
	
	String modelname=null;
	
	public void setModelname(String name){
		modelname=name;
	}
	
	public String getModelname(){
		return modelname;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserInteractionEnabled() {
		return userInteractionEnabled;
	}

	public void setUserInteractionEnabled(String userInteractionEnabled) {
		this.userInteractionEnabled = userInteractionEnabled;
	}

	public String getHorizontalHuggingPriority() {
		return horizontalHuggingPriority;
	}

	public void setHorizontalHuggingPriority(String horizontalHuggingPriority) {
		this.horizontalHuggingPriority = horizontalHuggingPriority;
	}

	public String getVerticalHuggingPriority() {
		return verticalHuggingPriority;
	}

	public void setVerticalHuggingPriority(String verticalHuggingPriority) {
		this.verticalHuggingPriority = verticalHuggingPriority;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTranslatesAutoresizingMaskIntoConstraints() {
		return translatesAutoresizingMaskIntoConstraints;
	}

	public void setTranslatesAutoresizingMaskIntoConstraints(
			String translatesAutoresizingMaskIntoConstraints) {
		this.translatesAutoresizingMaskIntoConstraints = translatesAutoresizingMaskIntoConstraints;
	}

	public String getMultipleTouchEnabled() {
		return multipleTouchEnabled;
	}

	public void setMultipleTouchEnabled(String multipleTouchEnabled) {
		this.multipleTouchEnabled = multipleTouchEnabled;
	}

	public String getClipsSubviews() {
		return clipsSubviews;
	}

	public void setClipsSubviews(String clipsSubviews) {
		this.clipsSubviews = clipsSubviews;
	}

	public String getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getRowHeight() {
		return rowHeight;
	}

	public void setRowHeight(String rowHeight) {
		this.rowHeight = rowHeight;
	}

	public String getSectionHeaderHeight() {
		return sectionHeaderHeight;
	}

	public void setSectionHeaderHeight(String sectionHeaderHeight) {
		this.sectionHeaderHeight = sectionHeaderHeight;
	}

	public String getSectionFooterHeight() {
		return sectionFooterHeight;
	}

	public void setSectionFooterHeight(String sectionFooterHeight) {
		this.sectionFooterHeight = sectionFooterHeight;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAlwaysBounceVertical() {
		return alwaysBounceVertical;
	}

	public void setAlwaysBounceVertical(String alwaysBounceVertical) {
		this.alwaysBounceVertical = alwaysBounceVertical;
	}

	public String getDataMode() {
		return dataMode;
	}

	public void setDataMode(String dataMode) {
		this.dataMode = dataMode;
	}

	public String getSeparatorStyle() {
		return separatorStyle;
	}

	public void setSeparatorStyle(String separatorStyle) {
		this.separatorStyle = separatorStyle;
	}

	public String getOpaque() {
		return opaque;
	}

	public void setOpaque(String opaque) {
		this.opaque = opaque;
	}

	public String getContentHorizontalAlignment() {
		return contentHorizontalAlignment;
	}

	public void setContentHorizontalAlignment(String contentHorizontalAlignment) {
		this.contentHorizontalAlignment = contentHorizontalAlignment;
	}

	public String getContentVerticalAlignment() {
		return contentVerticalAlignment;
	}

	public void setContentVerticalAlignment(String contentVerticalAlignment) {
		this.contentVerticalAlignment = contentVerticalAlignment;
	}

	public String getButtonType() {
		return buttonType;
	}

	public void setButtonType(String buttonType) {
		this.buttonType = buttonType;
	}

	public String getLineBreakMode() {
		return lineBreakMode;
	}

	public void setLineBreakMode(String lineBreakMode) {
		this.lineBreakMode = lineBreakMode;
	}

	public String getKey() {
		return key;
	}

	public String getContentMode() {
		return contentMode;
	}

	public AutoresizingMask getAutoresizingMask() {
		return autoresizingMask;
	}

	
	public void setKey(String K){
		key=K;
	}
	
	public void setContentMode(String C){
		contentMode=C;
	}
	
	public void addControl(ControlForIOS control){
		subcontrols.add(control);
	}
	
	public ArrayList<ControlForIOS> getSubControl(){
		return subcontrols;
	}
	
	public void addConstraint(Constraint constraint){
		constraints.add(constraint);
	}
	
	public void setRect(Rect R){
		rect=R;
	}
	
	public Rect getRect(){
		return rect;
	}

	public void setAutoresizingMask(AutoresizingMask A) {
		autoresizingMask=A;	
	}
	
	public void addColor(Color C){
		colors.add(C);
	}
	
	public ArrayList<Color> getColor(){
		return colors;
	}
	
	public void addConnection(Connection con){
		connections.add(con);
	}
	
	public void print(int num){
		for(int i=0;i<num;i++)
			System.out.print("    ");
		if(modelname!=null&&num>1){
			System.out.println("Modelname:"+modelname);
			return;
		}
		if(name!=null)System.out.print("Control:"+name);
		if(key!=null)System.out.print(" key:"+key);
		if(title!=null)System.out.print(" title:"+title);
		if(footerTitle!=null)System.out.print(" footerTitle:"+footerTitle);
		if(userInteractionEnabled!=null)System.out.print(" userInteractionEnabled:"+userInteractionEnabled);
		if(horizontalHuggingPriority!=null)System.out.print(" horizontalHuggingPriority:"+horizontalHuggingPriority);
		if(verticalHuggingPriority!=null)System.out.print(" verticalHuggingPriority:"+verticalHuggingPriority);
		if(image!=null)System.out.print(" image:"+image);
		if(translatesAutoresizingMaskIntoConstraints!=null)System.out.print(" translatesAutoresizingMaskIntoConstraints:"+translatesAutoresizingMaskIntoConstraints);
		if(multipleTouchEnabled!=null)System.out.print(" multipleTouchEnabled:"+multipleTouchEnabled);
		if(clipsSubviews!=null)System.out.print(" clipsSubviews:"+clipsSubviews);
		if(userLabel!=null)System.out.print(" height:"+userLabel);
		if(placeholder!=null)System.out.print(" placeholder:"+placeholder);
		if(backgroundImage!=null)System.out.print(" height:"+backgroundImage);
		if(contentMode!=null)System.out.print(" contentMode:"+contentMode);
		if(id!=null)System.out.print(" id:"+id);
		if(style!=null)System.out.print(" style:"+style);
		if(rowHeight!=null)System.out.print(" rowHeight:"+rowHeight);
		if(sectionHeaderHeight!=null)System.out.print(" sectionHeaderHeight:"+sectionHeaderHeight);
		if(sectionFooterHeight!=null)System.out.print(" sectionFooterHeight:"+sectionFooterHeight);
		if(text!=null)System.out.print(" text:"+text);
		if(alwaysBounceVertical!=null)System.out.print(" alwaysBounceVertical:"+alwaysBounceVertical);
		if(dataMode!=null)System.out.print(" dataMode:"+dataMode);
		if(separatorStyle!=null)System.out.print(" separatorStyle:"+separatorStyle);
		if(opaque!=null)System.out.print(" opaque:"+opaque);
		if(contentHorizontalAlignment!=null)System.out.print(" contentHorizontalAlignment:"+contentHorizontalAlignment);
		if(contentVerticalAlignment!=null)System.out.print(" contentVerticalAlignment:"+contentVerticalAlignment);
		if(buttonType!=null)System.out.print(" buttonType:"+buttonType);
		if(lineBreakMode!=null)System.out.print(" lineBreakMode:"+lineBreakMode);
		if(editable!=null)System.out.print(" editable:"+editable);
		if(showsHorizontalScrollIndicator!=null)System.out.print(" showsHorizontalScrollIndicator:"+showsHorizontalScrollIndicator);
		if(showsVerticalScrollIndicator!=null)System.out.print(" showsVerticalScrollIndicator:"+showsVerticalScrollIndicator);
		System.out.println();
		if(rect!=null)rect.print(num+1);
		if(fontDescription!=null)fontDescription.print(num+1);
		if(autoresizingMask!=null)autoresizingMask.print(num+1);
		for(int i=0;i<colors.size();i++)
			colors.get(i).print(num+1);	
		for(int i=0;i<states.size();i++)
			states.get(i).print(num+1);	
		for(int i=0;i<subcontrols.size();i++)
			subcontrols.get(i).print(num+1);
		for(int i=0;i<constraints.size();i++)
			constraints.get(i).print(num+1);
		for(int i=0;i<connections.size();i++)
			connections.get(i).print(num+1);
	}
}
