package IOS;

import java.util.HashMap;
import java.util.Map;

public class ControlsMap {
	Map<String,String> controls=new HashMap<String,String>();
	
	public ControlsMap(){
		controls.put("view ", "/view>");
		controls.put("scrollView ", "/scrollView>");
		controls.put("button ", "/button>");
		controls.put("searchBar ", "/searchBar>");
		controls.put("subviews ", "/subviews>");
		controls.put("tableViewCellContentView ", "/tableViewCellContentView>");
		controls.put("tableViewCell ", "/tableViewCell>");
		controls.put("tableViewSection ", "/tableViewSection>");
		controls.put("tableView ", "/tableView>");
		controls.put("label ", "/label>");
		controls.put("textView ", "/textView>");
		controls.put("navigationItem ", "/navigationItem>");
		controls.put("textAttributes ", "/textAttributes>");
		controls.put("tabBar ", "/tabBar>");
		controls.put("imageView ", "/imageView>");
		controls.put("barButtonItem ", "/barButtonItem>");
		controls.put("tabBarItem ", "/tabBarItem>");
		controls.put("navigationBar ", "/navigationBar>");
		controls.put("textField ", "/textField>");
		controls.put("collectionViewCell ", "/collectionViewCell>");
		controls.put("collectionView ", "/collectionView>");
		controls.put("collectionReusableView ", "/collectionReusableView>");
		controls.put("activityIndicatorView ", "/activityIndicatorView>");
		controls.put("switch ", "/switch>");
	}
	
	public Map<String,String> getMap(){
		return controls;
	}
}
