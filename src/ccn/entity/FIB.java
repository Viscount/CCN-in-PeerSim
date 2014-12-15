package ccn.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import peersim.core.Network;


public class FIB {

	/**
	 * @param args
	 */
	public Map detail;
	
	public FIB(){
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
	
	public void deleteEntry(String name){
		if (detail.containsKey(name)){
			detail.remove(name, detail.get(name));
		}
	}
	
	public int getNextHop(String name) {
		// TODO Auto-generated method stub
		int max_len = 0;
		Entry max_match_entry = null;
		for (Iterator it = detail.entrySet().iterator(); it.hasNext();){
			Entry entry = (Entry) it.next();
			String key = (String) entry.getKey();
			if (getCommonPrefix(key,name) > max_len){
				max_len = getCommonPrefix(key,name);
				max_match_entry = entry;
			}
		}
		if ( max_len == 0 ){
			// no match in FIB
			return -1;
		}
		else {
			int target =  (int) max_match_entry.getValue();
			return target;
		}
	}
	
	private int getCommonPrefix(String original, String target){
		int count = 0;
		while ((count < original.length())&& (count < target.length())){
			if (original.charAt(count) == target.charAt(count)) count++;
			else break;
		}
		if (( count < original.length() )&& ( count < target.length() )) return 0;
		else return count;
	}

}

