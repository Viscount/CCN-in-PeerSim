package ccn.entity;

import java.util.Iterator;
import java.util.List;

public class ContentStore {
	
	private List detail;
	private int cache_size;

	public ContentStore() {
		// TODO Auto-generated constructor stub
	}
	
	public DataItem get(int index){
		return (DataItem)detail.get(index);
	}
	
	public int contains(String name){
		int count = 0;
		for (Iterator it = detail.iterator(); it.hasNext();){
			DataItem contentName = (DataItem) it.next();
			if (contentName.getName().equals(name) ) return (count);
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
	
	public void performCache(Message message, String cache_method, String replace_method){
		
	}

}
