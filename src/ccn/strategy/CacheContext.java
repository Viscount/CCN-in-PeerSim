package ccn.strategy;

import java.util.List;

import peersim.core.Node;

import ccn.entity.ContentStore;
import ccn.entity.Message;

public class CacheContext {
	
	public CacheStrategy cachestrategy;

	public CacheContext(Node node, int protocolID, Message message, String type) {
		// TODO Auto-generated constructor stub

		switch (type)
		{
			case "LCE":
				LCE lce = new LCE();
				break;
		}
	}
	
	public void performCache(Node node, int protocolID, Message message){
		cachestrategy.cache(node, protocolID, message);
	}

}
