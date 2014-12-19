package ccn.entity;

import java.util.Iterator;
import java.util.List;

import peersim.core.CommonState;

import ccn.strategy.CacheContext;
import ccn.strategy.ReplaceContext;

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
	
	public void addItem(String name){
		DataItem data = new DataItem(name,CommonState.getTime());
		detail.add(data);
	}
	
	public void updateTime(String name){
		int index = this.contains(name);
		DataItem data = new DataItem(name,CommonState.getTime());
		detail.set(index, data);
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

	public int getLatestItem() {
		// TODO Auto-generated method stub
		long minTime = Long.MAX_VALUE;
		int index = -1;
		for (int i=0; i<detail.size(); i++){
			DataItem data_item = (DataItem) detail.get(i);
			if ( data_item.getTime() < minTime ){
				minTime = data_item.getTime();
				index = i;
			}
		}
		return index;
	}
	
	public void remove(int index){
		detail.remove(index);
	}

}
