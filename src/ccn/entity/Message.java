package ccn.entity;

public class Message {
	
	private String messageType;
	private int requester;
	private int dataSize;
	private String dataName;
	private int TTL;
	

	public Message(String type, int request, String name) {
		// TODO Auto-generated constructor stub
		this.messageType = type;
		this.requester = request;
		this.dataName = name;
	}
	
	public int getDataSize(){
		return dataSize;
	}
	
	public String getMessageType(){
		return messageType;
	}
	
	public String getDataName(){
		return dataName;
	}
	
	public int getRequester(){
		return requester;
	}
}
