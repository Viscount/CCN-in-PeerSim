package ccn.strategy;

import peersim.core.Node;
import ccn.entity.Message;
import ccn.protocol.Infrastructure;

public class ReplaceContext {
	
	public ReplaceStrategy replacestrategy;

	public ReplaceContext(String type) {
		// TODO Auto-generated constructor stub
		
		switch (type)
		{
			case "LRU":
				LRU lru = new LRU();
				break;
		}
	}
	
	public void performReplace(Node node, int protocolID, Message message){
		replacestrategy.replace(node, protocolID, message);
	}

}
