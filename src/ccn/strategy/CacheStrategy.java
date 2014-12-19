package ccn.strategy;

import peersim.core.Node;
import ccn.entity.Message;
import ccn.protocol.Infrastructure;

public abstract class CacheStrategy {
	
	public abstract void cache(Node node, int protocolID, Message message);

}
