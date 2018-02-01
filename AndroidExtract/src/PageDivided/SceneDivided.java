package PageDivided;

import java.util.ArrayList;

import IOS.ControlForIOS;
import IOS.IOSRead;
import IOS.ViewForIOS;

public class SceneDivided {
	
	ArrayList<ModelForIOS> models=new ArrayList<ModelForIOS>();
	ControlTree controltree=new ControlTree();
	
	public ArrayList<ModelForIOS> sceneDivided(ViewForIOS view) throws Exception{
		
		for(int i=0;i<view.getControls().size();i++){
			controltree=new ControlTree();
			ControlForIOS control=view.getControls().get(i);
			getModel(control);
			ModelForIOS model=new ModelForIOS();
			model.setName("model"+(models.size()+1));
			model.setControl(control);
			models.add(model);
			control.setModelname("model"+models.size());
		}
		return models;
	}
	
	public void getModel(ControlForIOS control){
		controltree.push(control);
		if(control.getName().equals("label ")||control.getName().equals("button ")||control.getName().equals("label ")){			
			int i=2;
			ControlForIOS controlparent=controltree.getParent(i);
			while(controlparent!=null&&controlparent.getSubControl().size()!=1){
				i++;
				controlparent=controltree.getParent(i);
			}
			if(controlparent!=null&&controlparent.getModelname()==null){
				ModelForIOS model=new ModelForIOS();
				model.setName("model"+(models.size()+1));
				model.setControl(controlparent);
				models.add(model);
				controlparent.setModelname("model"+models.size());
			}
		}
		for(int i=0;i<control.getSubControl().size();i++)
			getModel(control.getSubControl().get(i));
		controltree.pop();
	}
}
