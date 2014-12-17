package ccn.entity;

public class DataItem {
	
	private String dataName;
	private long timeStamp;

	public DataItem(String name, long time) {
		// TODO Auto-generated constructor stub
		dataName = name;
		timeStamp = time;
	}
	
	public String getName(){
		return dataName;
	}
	
	public long getTime(){
		return timeStamp;
	}
	
	public void setName(String name){
		dataName = name;
	}
	
	public void setTime(long time){
		timeStamp = time;
	}

}
