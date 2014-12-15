package ccn.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PIT {

	/**
	 * @param args
	 */
	public Map detail;
	
	public PIT(){
		detail = new HashMap<String,List>();
	}
	
	public boolean containsKey(Object key){
		return detail.containsKey(key);
	}
	
	public Object put(Object key, Object value){
		return detail.put(key, value);
	}
	
	public Object get(Object key){
		return detail.get(key);
	}
	
	public Set entrySet(){
		return detail.entrySet();
	}
	
	public void addFace(String name, String nodeID){
		if (!detail.containsKey(name)) return;
		List facelist = (List) detail.get(name);
		if ( facelist.contains(nodeID) ) return;
		else{
			facelist.add(nodeID);
			detail.put(name, facelist);
		}
	}
	
	public List getFace(String name){
		if (!detail.containsKey(name)) return null;
		List facelist = (List) detail.get(name);
		return facelist;
	}

}
