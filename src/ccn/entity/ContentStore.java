package ccn.entity;

import java.util.Iterator;
import java.util.List;

public class ContentStore {
	
	private List detail;
	private int cache_size;

	public ContentStore() {
		// TODO Auto-generated constructor stub
	}
	
	public String get(int index){
		return (String)detail.get(index);
	}
	
	public int contains(String name){
		int count = 0;
		for (Iterator it = detail.iterator(); it.hasNext();){
			String contentName = (String) it.next();
			if (contentName.equals(name) ) return (count);
			count++;
		}
		return -1 ;
	}
	
	public int size(){
		return detail.size();
	}
	
	public void setCacheSize(int size){
		cache_size = size;
	}
	
	public int getCacheSize(){
		return cache_size;
	}

}
